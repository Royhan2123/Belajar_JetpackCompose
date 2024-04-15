package com.example.learngetapi.api

import com.example.learngetapi.model.DataModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {

    @POST("users")
    fun postData(@Body dataModel: DataModel?) : Call<DataModel>?
}