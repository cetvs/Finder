package com.example.finder.feature.auth.domain.usecases

import com.example.finder.feature.auth.domain.AuthRepository

class AuthInteractor(private val authRepository: AuthRepository) {
    suspend fun registerUser(phoneNumber: String) {
        authRepository.registerUser(phoneNumber)
    }
}