package com.example.finder.feature.auth.di

import com.example.finder.feature.auth.domain.AuthRepository
import com.example.finder.feature.auth.data.AuthRepositoryImpl
import com.example.finder.feature.auth.data.api.AuthApi
import com.example.finder.feature.auth.domain.usecases.AuthInteractor
import com.example.finder.feature.auth.presentation.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AuthModule {
    val authModule = module {
        single {
            Retrofit.Builder()
                .baseUrl("http://10.0.2.2:9000")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        single { get<Retrofit>().create(AuthApi::class.java) }
        single<AuthRepository> { AuthRepositoryImpl(get()) }
        single { AuthInteractor(get()) }
        viewModel { AuthViewModel(get()) }
    }
}