package com.example.learngetapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {

}


@Composable
@Preview
fun PreviewHomeScreen(){
    HomeScreen(navController = rememberNavController())
}