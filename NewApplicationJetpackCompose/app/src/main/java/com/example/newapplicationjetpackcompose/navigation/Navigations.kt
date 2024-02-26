package com.example.newapplicationjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newapplicationjetpackcompose.SplashScreen
import com.example.newapplicationjetpackcompose.ui.page.AccountPage
import com.example.newapplicationjetpackcompose.ui.page.HomePage
import com.example.newapplicationjetpackcompose.ui.page.SearchPage

@Composable
fun Navigation() {
    val navController = rememberNavController()
    

    NavHost(navController = navController,
        startDestination = NavigationScreen.SplashScreen.name){
        composable(NavigationScreen.SplashScreen.name){
            SplashScreen(navController)
        }
        composable(NavigationScreen.HomePage.name){
            HomePage(navController)
        }
        composable(NavigationScreen.AccountPage.name){
            AccountPage(navController)
        }
        composable(NavigationScreen.SearchPage.name){
            SearchPage(navController)
        }
    }
}