package com.example.finder.feature.chat.data

import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun sendChatMessage(messageText: String)
    fun connectWebsocketAndListen(): Flow<ChatMessage>
}

class ChatRepositoryImpl(private val chatWebsocketApi: ChatWebsocketApi) : ChatRepository {
    override fun sendChatMessage(messageText: String) {
        chatWebsocketApi.sendChatMessage(messageText)
    }

    override fun connectWebsocketAndListen(): Flow<ChatMessage> {
        return chatWebsocketApi.connectWebsocketAndListen()
    }
}