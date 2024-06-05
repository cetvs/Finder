package com.example.finder.feature.chat.presentation


import android.util.Log
import androidx.lifecycle.ViewModel
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import java.util.concurrent.TimeUnit

class ChatViewModel : ViewModel() {

    private var webSocket: WebSocket? = null
    private val client: OkHttpClient

    init {
        client = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
        connectWebSocket()
    }

    private fun listener() {

    }

    private fun connectWebSocket() {
        val request = Request.Builder()
            .url("ws://10.0.2.2:9000/ws")
            .build()
        val listener = object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                Log.v(TAG, "onOpen")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                Log.v(TAG, "onMessage = $text")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                Log.v(TAG, "onFailure")
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                Log.v(TAG, "onFailure")
            }
        }

        webSocket = client.newWebSocket(request, listener)
    }

    companion object {
        private const val TAG = "ChatViewModel"
    }
}