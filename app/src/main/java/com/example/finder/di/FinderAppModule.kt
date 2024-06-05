package com.example.finder.di

import com.example.finder.feature.auth.di.AuthModule
import com.example.finder.feature.chat.di.ChatModule
import org.koin.dsl.module

object FinderAppModule {
    val finderAppModule = module {
        includes(AuthModule.authModule, ChatModule.chatModule)
    }
}