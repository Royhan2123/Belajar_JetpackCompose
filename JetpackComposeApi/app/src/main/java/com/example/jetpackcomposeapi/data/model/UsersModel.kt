package com.example.jetpackcomposeapi.data.model

import com.google.gson.annotations.SerializedName

data class UsersModel(
    @SerializedName("balance") val balance: Int,
    @SerializedName("card_number") val cardNumber: String,
    @SerializedName("email") val email: String,
    @SerializedName("id") val id: Int,
    @SerializedName("ktp") val ktp: String,
    @SerializedName("name") val name: String,
    @SerializedName("profile_picture") val profilePicture: String,
    @SerializedName("username") val username: String
)