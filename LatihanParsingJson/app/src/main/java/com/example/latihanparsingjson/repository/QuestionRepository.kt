package com.example.latihanparsingjson.repository

import android.util.Log
import com.example.latihanparsingjson.data.DataOrException
import com.example.latihanparsingjson.model.QuestionItem
import com.example.latihanparsingjson.network.QuestionApi
import javax.inject.Inject


class QuestionRepository @Inject constructor(
    private val api:QuestionApi
) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()

    suspend fun getAllQuestion():DataOrException<ArrayList<QuestionItem>,Boolean,Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestion()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        }catch (e:Exception){
            dataOrException.e = e
            Log.d("Exc", "getAllQuestion: ${dataOrException.e!!.localizedMessage}")

        }
        return dataOrException
    }
}
