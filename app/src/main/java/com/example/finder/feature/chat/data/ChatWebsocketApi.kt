package com.example.finder.feature.chat.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import java.util.concurrent.TimeUnit

class ChatWebsocketApi {
    private val chatWebsocketMapper = ChatWebsocketMapper()
    private var webSocket: WebSocket? = null
    private val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .build()
    private var isOpenWebSocket: Boolean = false

    private val chatMessage = MutableStateFlow<ChatMessage?>(null)

    private fun connectWebSocket() {
        val request = Request.Builder()
            .url("ws://10.0.2.2:9000/ws_chat")
            .build()
        val listener = object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                Log.v(TAG, "onOpen")
                isOpenWebSocket = true
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                Log.v(TAG, "onMessage = $text")
                Log.v(TAG, "mapMessage = ${chatWebsocketMapper.mapToChatMessage(text)}")
                chatMessage.value = chatWebsocketMapper.mapToChatMessage(text)
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                Log.v(TAG, "onFailure")
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                Log.v(TAG, "onClosed")
                isOpenWebSocket = false
            }
        }

        webSocket = client.newWebSocket(request, listener)
    }

    fun sendChatMessage(messageText: String) {
        webSocket?.send(messageText)
    }

    fun connectWebsocketAndListen(): Flow<ChatMessage> {
        connectWebSocket()
        return chatMessage.filterNotNull()
    }

    companion object {
        private const val TAG = "ChatWebsocketApi"
    }
}