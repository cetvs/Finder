package com.example.finder.feature.auth.data

class AuthRepositoryImpl : AuthRepository {

    override fun isRegisterPhoneExist(phoneNumber: Long): Boolean {
        return true
    }

    override fun registerUser() {

    }

    override fun loginUser() {}
}