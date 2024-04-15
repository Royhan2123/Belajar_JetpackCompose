package com.example.learngetapi.ui

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun SplashScreen(navController: NavController){

}

@Preview
@Composable
fun PreviewSplashScreen(){
    SplashScreen(rememberNavController())
}