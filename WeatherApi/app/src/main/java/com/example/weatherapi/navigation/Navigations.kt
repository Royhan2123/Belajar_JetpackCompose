package com.example.weatherapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapi.SplashScreen
import com.example.weatherapi.halamanBottom.HalamanBottom
import com.example.weatherapi.page.Account
import com.example.weatherapi.page.Home
import com.example.weatherapi.page.Search

@Composable
fun Navigations(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationScreen.SplashScreen.name){
        composable(NavigationScreen.SplashScreen.name){
            SplashScreen(navController = navController)
        }
        composable(NavigationScreen.HalamanBottom.name){
            HalamanBottom()
        }
        composable(NavigationScreen.Home.name){
            Home(navController = navController)
        }
        composable(NavigationScreen.Search.name){
            Search(navController = navController)
        }
        composable(NavigationScreen.Account.name){
            Account(navController = navController)
        }
    }
}