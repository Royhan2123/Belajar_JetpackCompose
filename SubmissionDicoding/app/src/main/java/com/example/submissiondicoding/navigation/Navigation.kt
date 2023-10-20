package com.example.submissiondicoding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.submissiondicoding.Account
import com.example.submissiondicoding.BottomNavigationApp
import com.example.submissiondicoding.Detail
import com.example.submissiondicoding.Home
import com.example.submissiondicoding.SplashScreen

@Composable
fun Navigations(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.SplashScreen.name){
        composable(NavigationScreen.SplashScreen.name){
            SplashScreen(navController = navController)
        }
        composable(NavigationScreen.Home.name){
            Home(navController = navController)
        }
        composable(NavigationScreen.Detail.name){
            Detail(navController = navController)
        }
        composable(NavigationScreen.Account.name){
            Account(navController = navController)
        }
    }
}