package com.example.finder.feature.auth.data

interface AuthRepository {
    fun registerUser()
    fun isRegisterPhoneExist(phoneNumber: Long): Boolean
    fun loginUser()
}