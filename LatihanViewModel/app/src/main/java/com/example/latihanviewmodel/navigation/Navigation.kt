package com.example.latihanviewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.latihanviewmodel.screen.Account
import com.example.latihanviewmodel.HalamanBottom
import com.example.latihanviewmodel.screen.HomePage
import com.example.latihanviewmodel.screen.Search
import com.example.latihanviewmodel.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationSreen.SplashScreen.name
    ) {
        composable(NavigationSreen.SplashScreen.name){
            SplashScreen(navController = navController)
        }
        composable(NavigationSreen.HomePage.name){
            HomePage(navController = navController)
        }
        composable(NavigationSreen.Search.name){
            Search(navController = navController)
        }
        composable(NavigationSreen.Account.name){
            Account(navController = navController)
        }
        composable(NavigationSreen.HalamanBottom.name){
            HalamanBottom()
        }
    }
}