package com.example.jetpackcomposeapi.data.response.model

data class UsersModel(
    val balance: Int,
    val card_number: String,
    val email: String,
    val id: Int,
    val ktp: String,
    val name: String,
    val profile_picture: String,
    val username: String
)