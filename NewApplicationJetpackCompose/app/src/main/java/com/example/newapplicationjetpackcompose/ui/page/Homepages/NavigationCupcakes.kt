package com.example.newapplicationjetpackcompose.ui.page.Homepages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationCupcakes(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(text = "NAVIGATION CUPCAKES")
    }
}

@Preview (showSystemUi = true)
@Composable
fun PreviewNavigationCupcakes(){
    NavigationCupcakes(navController = rememberNavController())
}
