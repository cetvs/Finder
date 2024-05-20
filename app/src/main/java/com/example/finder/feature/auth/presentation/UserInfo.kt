package com.example.finder.feature.auth.presentation

import com.example.finder.feature.auth.domain.usecases.UserInfoDomain

data class UserInfo(
    val phoneNumber: String,
    val name: String,
)

inline fun UserInfoDomain.toUserInfo() = UserInfo(
    phoneNumber = phoneNumber,
    name = name,
)