package com.example.jetpackcomposeapi.data.model

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)
