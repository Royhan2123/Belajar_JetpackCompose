package com.example.learngetapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learngetapi.SignInScreen
import com.example.learngetapi.page.SplashScreen

@Composable
fun Navigations() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.SplashScreen.name
    ) {
        composable(NavigationScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(NavigationScreen.SignInScreen.name) {
            SignInScreen(navController = navController)
        }
    }
}