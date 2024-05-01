package com.example.jetpackcomposeapi.data.model

import com.google.gson.annotations.SerializedName

data class RegisterModel(
    @SerializedName("email") val email: String,
    @SerializedName("ktp") val ktp: String,
    @SerializedName("name") val name: String,
    @SerializedName("password") val password: String,
    @SerializedName("pin") val pin: Int,
    @SerializedName("profile_picture") val profile_picture: String
)