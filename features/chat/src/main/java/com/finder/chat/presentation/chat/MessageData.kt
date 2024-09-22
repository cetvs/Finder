package com.finder.chat.presentation.chat

import java.util.Date

data class MessageData(
    val text: String,
    val time: Date,
    val messageType: MessageType,
)
