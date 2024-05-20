package com.example.finder.feature.auth.data

import com.example.finder.feature.auth.data.api.AuthApi
import com.example.finder.feature.auth.domain.AuthRepository

class AuthRepositoryImpl(val authApi: AuthApi) : AuthRepository {

    override fun isRegisterPhoneExist(phoneNumber: String): Boolean {
        return true
    }

    override suspend fun registerUser(phoneNumber: String) {
        authApi.registerUser(phoneNumber)
    }

    override fun loginUser() {}
}