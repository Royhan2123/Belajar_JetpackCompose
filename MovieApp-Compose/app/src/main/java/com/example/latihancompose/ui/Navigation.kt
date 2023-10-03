package com.example.latihancompose.ui

import NavigationScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.latihancompose.ui.Page.HomePage
import com.example.latihancompose.SplashScreen
import com.example.latihancompose.ui.Page.DetailPage


@Composable
fun IniNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = NavigationScreen.SplashScreen.name){
        composable(NavigationScreen.SplashScreen.name){
        SplashScreen(navController = navController)
        }
        composable(NavigationScreen.HomePage.name){
        HomePage(navController = navController)
        }
        composable(NavigationScreen.DetailPage.name){
            DetailPage(navController = navController)
        }
    }
}
