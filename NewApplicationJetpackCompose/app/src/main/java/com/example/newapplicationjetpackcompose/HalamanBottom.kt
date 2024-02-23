package com.example.newapplicationjetpackcompose

import androidx.compose.material.BottomNavigation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newapplicationjetpackcompose.page.AccountPage
import com.example.newapplicationjetpackcompose.page.HomePage
import com.example.newapplicationjetpackcompose.page.SearchPage
import com.example.newapplicationjetpackcompose.NavigationScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanBottom() {
    val navController = rememberNavController()

    val items = listOf(
        NavigationScreen.HomePage.title,
        NavigationScreen.SearchPage.title,
        NavigationScreen.AccountPage.title,
    )
    NavHost(navController = navController,
        startDestination = NavigationScreen.HomePage.title ){
        composable(NavigationScreen.HomePage.title) {
            HomePage(navController = navController)
        }
        composable(NavigationScreen.SearchPage.title) {
            SearchPage(navController = navController)
        }
        composable(NavigationScreen.AccountPage.title) {
            AccountPage(navController = navController)
        }
    }


    Scaffold (
        bottomBar = {
         BottomNavigation {
             val navBackStackEntry by navController.currentBackStackEntryAsState()
             val currentRoute = navBackStackEntry?.destination?.route
         }
        }
    ) {

    }
}
sealed class NavigationScreen(val title: String) {
    object HomePage : NavigationScreen("Home")
    object SearchPage : NavigationScreen("Detail")
    object AccountPage : NavigationScreen("Account")
}