package com.example.latihanparsingjson.component

import android.util.Log
import androidx.compose.runtime.Composable
import com.example.latihanparsingjson.screens.QuestionViewModel

@Composable
fun Questions(viewModel: QuestionViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true) {
        Log.d("Loading", "Question ... Loading")
    } else {
        Log.d("SIZE", "Question : Loading Stopped")
        questions?.forEach { questionItem ->
            Log.d("SIZE", "Question : ${questionItem.question}")
        }
    }
    Log.d("SIZE", "Question : ${questions?.size}")

}