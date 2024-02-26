package com.example.newapplicationjetpackcompose.ui.page


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomePage(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start,
    ) {

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomePage(){
    HomePage(navController = rememberNavController())
}