package com.finder.chat.presentation.chat

sealed class MessageType{
    data class MessageOut(val isViewed: Boolean) : MessageType()
    object MessageIn : MessageType()
}
