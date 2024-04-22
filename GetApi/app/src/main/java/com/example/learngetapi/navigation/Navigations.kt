package com.example.learngetapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learngetapi.HomeScreen

@Composable
fun Navigations() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.HomeScreen.name
    ) {
        composable(NavigationScreen.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
    }
}