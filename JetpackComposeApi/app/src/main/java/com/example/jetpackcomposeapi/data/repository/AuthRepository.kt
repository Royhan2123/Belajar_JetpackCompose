package com.example.jetpackcomposeapi.data.repository

import com.example.jetpackcomposeapi.data.model.LoginModel
import com.example.jetpackcomposeapi.data.response.RetrofitClient

class AuthRepository {
    private val authServices = RetrofitClient.apiConfig()

    suspend fun login(email:String, password:String) {
        try {
            val loginModel = LoginModel(email, password)
            val user = authServices.login(loginModel)
        } catch ( e:Exception ) {
            throw e
        }
    }
}