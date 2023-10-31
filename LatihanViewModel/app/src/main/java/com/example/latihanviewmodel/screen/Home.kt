package com.example.latihanviewmodel.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.latihanviewmodel.components.NotesScreen
import com.example.latihanviewmodel.model.Note

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomePage(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}

@Preview
@Composable
fun PreviewsHome() {
    HomePage(navController = rememberNavController())
}