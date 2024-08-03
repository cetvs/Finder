package com.finder.chat.domain

import com.finder.chat.data.ChatMessage
import com.finder.chat.data.ChatRepository
import kotlinx.coroutines.flow.Flow

class ChatInteractor(private val chatRepository: ChatRepository) {

    fun sendChatMessage(messageText: String) {
        chatRepository.sendChatMessage(messageText)
    }

    fun connectWebsocketAndListen(): Flow<ChatMessage> {
        return chatRepository.connectWebsocketAndListen()
    }

}
