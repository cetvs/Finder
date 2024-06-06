package com.example.finder.feature.chat.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finder.feature.chat.data.ChatMessage
import com.example.finder.feature.chat.domain.ChatInteractor
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ChatViewModel(private val chatInteractor: ChatInteractor) : ViewModel() {

    val messages: StateFlow<ChatMessage?> = chatInteractor.connectWebsocketAndListen()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = null
        )

    fun sendMessage(message: String) {
        chatInteractor.sendChatMessage(message)
    }

    companion object {
        private const val TAG = "ChatViewModel"
    }
}