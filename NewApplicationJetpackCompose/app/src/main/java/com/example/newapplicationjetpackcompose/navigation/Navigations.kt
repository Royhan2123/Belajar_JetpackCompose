package com.example.newapplicationjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newapplicationjetpackcompose.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    

    NavHost(navController = navController,
        startDestination = NavigationScreen.SplashScreen.name){
        composable(NavigationScreen.SplashScreen.name){
            SplashScreen(navController)
        }
        composable()
    }
}