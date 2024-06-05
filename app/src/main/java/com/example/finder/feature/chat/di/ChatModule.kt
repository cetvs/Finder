package com.example.finder.feature.chat.di

import com.example.finder.feature.chat.presentation.ChatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ChatModule {
    val chatModule = module {
        viewModel { ChatViewModel() }
    }
}