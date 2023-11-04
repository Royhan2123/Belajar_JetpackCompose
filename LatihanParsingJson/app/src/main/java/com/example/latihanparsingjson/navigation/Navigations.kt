package com.example.latihanparsingjson.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.latihanparsingjson.page.AccountPage
import com.example.latihanparsingjson.page.HomePage


@Composable
fun Navigations(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationScreen.HalamanBottom.name){
        composable(NavigationScreen.HalamanBottom.name){
            HalamanBottom()
        }
        composable(NavigationScreen.HomePage.name){
            HomePage(navController = navController)
        }
        composable(NavigationScreen.AccountPage.name){
            AccountPage(navController = navController)
        }
    }
}