package com.example.finder.feature.auth.domain

interface AuthRepository {
    suspend fun registerUser(phoneNumber: String)
    fun isRegisterPhoneExist(phoneNumber: String): Boolean
    fun loginUser()
}