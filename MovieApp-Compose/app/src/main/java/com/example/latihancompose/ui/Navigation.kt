package com.example.latihancompose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.latihancompose.ui.Login
import com.example.latihancompose.ui.NavigationScreen
import com.example.latihancompose.ui.Page.DetailPage
import com.example.latihancompose.ui.Page.HomePage
import com.example.latihancompose.ui.Register
import com.example.latihancompose.ui.SplashScreen

@Composable
fun Navigations(){
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
        composable(NavigationScreen.Login.name){
            Login(navController = navController)
        }
        composable(NavigationScreen.Register.name){
            Register(navController = navController)
        }

    }
}