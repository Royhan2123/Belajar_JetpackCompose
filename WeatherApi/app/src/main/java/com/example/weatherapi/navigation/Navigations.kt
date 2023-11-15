package com.example.weatherapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapi.HalamanBottom
import com.example.weatherapi.SplashScreen
import com.example.weatherapi.SplashScreen2
import com.example.weatherapi.screen.Account
import com.example.weatherapi.screen.HomePage
import com.example.weatherapi.screen.Search

@Composable
fun Navigations(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationScreen.SplashScreen.name){
        composable(NavigationScreen.SplashScreen.name){
            SplashScreen(navController = navController)
        }
        composable(NavigationScreen.SplashScreen2.name){
            SplashScreen2(navController = navController)
        }
        composable(NavigationScreen.HalamanBottom.name){
            HalamanBottom()
        }
        composable(NavigationScreen.HomePage.name){
            HomePage(navController)
        }
        composable(NavigationScreen.Search.name){
            Search(navController)
        }
        composable(NavigationScreen.Account.name){
            Account(navController)
        }
    }
}