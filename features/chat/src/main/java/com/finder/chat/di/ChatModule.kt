package com.finder.chat.di

import com.finder.chat.data.ChatRepositoryImpl
import com.finder.chat.data.ChatWebsocketApi
import com.finder.chat.data.ChatRepository
import com.finder.chat.domain.ChatInteractor
import com.example.finder.feature.chat.presentation.ChatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ChatModule {
    val chatModule = module {
        single { ChatWebsocketApi() }
        single<ChatRepository> { ChatRepositoryImpl(get()) }
        single { ChatInteractor(get()) }
        viewModel { ChatViewModel(get()) }
    }
}
