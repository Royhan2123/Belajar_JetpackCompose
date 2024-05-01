package com.example.jetpackcomposeapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapi.page.AccountScreen
import com.example.jetpackcomposeapi.page.HalamanBottom
import com.example.jetpackcomposeapi.page.HomeScreen
import com.example.jetpackcomposeapi.page.SearchScreen
import com.example.jetpackcomposeapi.page.SignInScreen
import com.example.jetpackcomposeapi.page.SignUpScreen
import com.example.jetpackcomposeapi.page.SignUpSetKtp
import com.example.jetpackcomposeapi.page.SignUpSetPin
import com.example.jetpackcomposeapi.page.SplashScreen

@Composable
fun Navigations() {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = NavigationScreen.SplashScreen.name) {
        composable(NavigationScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(NavigationScreen.SignInScreen.name) {
            SignInScreen(navController = navController)
        }
        composable(NavigationScreen.SignUpScreen.name) {
            SignUpScreen(navController = navController)
        }
        composable(NavigationScreen.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(NavigationScreen.SignUpSetPin.name) {
            SignUpSetPin(navController = navController)
        }
        composable(NavigationScreen.SignUpSetKtp.name) {
            SignUpSetKtp(navController = navController)
        }
        composable(NavigationScreen.HalamanBottom.name) {
            HalamanBottom()
        }
        composable(NavigationScreen.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
        composable(NavigationScreen.AccountScreen.name) {
            AccountScreen(navController = navController)
        }

    }
}
