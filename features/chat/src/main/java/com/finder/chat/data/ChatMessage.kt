package com.finder.chat.data

import java.sql.Date

data class ChatMessage(
    val id: String? = null,
    val chatId: String? = null,
    val senderId: String? = null,
    val recipientId: String? = null,
    val senderName: String? = null,
    val recipientName: String? = null,
    val content: String? = null,
    val timestamp: Date? = null,
    val status: MessageStatus? = null,
)

enum class MessageStatus {
    RECEIVED, DELIVERED
}
