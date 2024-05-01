package com.example.jetpackcomposeapi.data.response

import com.example.jetpackcomposeapi.Constant
import com.example.jetpackcomposeapi.data.services.AuthServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitClient {
    fun apiConfig(): AuthServices {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthServices::class.java)
    }
}