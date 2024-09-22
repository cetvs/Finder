package com.finder.chat.presentation.chat


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finder.chat.domain.ChatInteractor
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ChatViewModel(private val chatInteractor: ChatInteractor) : ViewModel() {

    //TODO(profile backend)
//    val profileData: StateFlow<ProfileData?> = Flow<ProfileData?>()

    var messages = chatInteractor.connectWebsocketAndListen()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = null
        )

    fun connectToChat() {
        messages = chatInteractor.connectWebsocketAndListen()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Lazily,
                initialValue = null
            )
    }

    fun sendMessage(message: String) {
        chatInteractor.sendChatMessage(message)
    }

    companion object {
        private const val TAG = "ChatViewModel"
    }
}
