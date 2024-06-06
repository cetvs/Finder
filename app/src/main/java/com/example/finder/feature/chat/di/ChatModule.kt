package com.example.finder.feature.chat.di

import com.example.finder.feature.chat.data.ChatRepositoryImpl
import com.example.finder.feature.chat.data.ChatWebsocketApi
import com.example.finder.feature.chat.data.ChatRepository
import com.example.finder.feature.chat.domain.ChatInteractor
import com.example.finder.feature.chat.presentation.ChatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ChatModule {
    val chatModule = module {
        single { ChatWebsocketApi()}
        single<ChatRepository> { ChatRepositoryImpl(get()) }
        single { ChatInteractor(get())}
        viewModel { ChatViewModel(get()) }
    }
}