package com.example.learngetapi.api

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.example.learngetapi.model.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun apiConfig(
    ctx: Context,
    userName: MutableState<TextFieldValue>,
    job: MutableState<TextFieldValue>,
    result: MutableState<String>
) {


    // url yang dipakai.
    val url = "https://reqres.in/api"


    // untuk menambahkan apiServices ke dalam apiConfig.
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitApi = retrofit.create(ApiServices::class.java)

    val dataModel = DataModel(
        userName.value.text,
        job.value.text
    )

    val call : Call<DataModel>? = retrofitApi.postData(dataModel)

    call!!.enqueue(object : Callback<DataModel?> {
        override fun onResponse(call: Call<DataModel?>, response: Response<DataModel?>) {
            Toast.makeText(ctx, "Data posted in API", Toast.LENGTH_SHORT).show()

            val model: DataModel? = response.body()

            val responBody = "Respon Code : " + response.code() + "\n" + "User Name : " + "\n" + "Job : " + model!!.job
            result.value = responBody
        }

        override fun onFailure(call: Call<DataModel?>, t: Throwable) {
            result.value = "Error Found is : " + t.message
        }
    })
}