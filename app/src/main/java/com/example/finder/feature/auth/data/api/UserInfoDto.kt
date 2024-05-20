package com.example.finder.feature.auth.data.api

import com.example.finder.feature.auth.domain.usecases.UserInfoDomain

data class UserInfoDto (
    val phoneNumber: String,
    val name: String,
)

inline fun UserInfoDomain.toUserInfoDto() = UserInfoDto(
    phoneNumber = phoneNumber,
    name = name,
)