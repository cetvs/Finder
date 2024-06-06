package com.example.finder.feature.chat.domain

import com.example.finder.feature.chat.data.ChatMessage
import com.example.finder.feature.chat.data.ChatRepository
import kotlinx.coroutines.flow.Flow

class ChatInteractor(private val chatRepository: ChatRepository) {

    fun sendChatMessage(messageText: String) {
        chatRepository.sendChatMessage(messageText)
    }

    fun connectWebsocketAndListen(): Flow<ChatMessage> {
        return chatRepository.connectWebsocketAndListen()
    }

}