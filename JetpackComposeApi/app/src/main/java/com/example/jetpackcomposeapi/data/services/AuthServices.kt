package com.example.jetpackcomposeapi.data.services

import com.example.jetpackcomposeapi.data.model.LoginModel
import com.example.jetpackcomposeapi.data.model.RegisterModel
import com.example.jetpackcomposeapi.data.model.UsersModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthServices {
    @POST("login")
    suspend fun login(@Body data:LoginModel) : UsersModel

    @POST("register")
    suspend fun register(@Body data: RegisterModel) : UsersModel

    @POST("is-email-exist")
    suspend fun checkEmail(checkEmail: String): RegisterModel
}