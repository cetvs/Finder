package com.example.finder.feature.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finder.feature.auth.domain.usecases.AuthInteractor
import kotlinx.coroutines.launch

class AuthViewModel(private val authInteractor: AuthInteractor) : ViewModel() {

    fun registerUser(phoneNumber: String) {
        viewModelScope.launch {
            authInteractor.registerUser(phoneNumber)
        }
    }
}