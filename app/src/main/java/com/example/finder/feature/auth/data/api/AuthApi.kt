package com.example.finder.feature.auth.data.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("/finder/v1/auth/register")
    suspend fun registerUser(@Field("phoneNumber") phoneNumber: String)

    companion object {

    }
}