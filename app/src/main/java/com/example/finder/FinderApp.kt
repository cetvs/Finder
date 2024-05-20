package com.example.finder

import android.app.Application
import com.example.finder.di.FinderAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FinderApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FinderApp)
            modules(FinderAppModule.finderAppModule)
        }
    }
}