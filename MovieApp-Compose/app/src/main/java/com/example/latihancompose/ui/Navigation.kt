package com.example.latihancompose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.latihancompose.ui.Page.DetailPage
import com.example.latihancompose.ui.Page.HomePage

@Composable
fun Navigations() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.SplashScreen.name
    ) {
        composable(NavigationScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(NavigationScreen.HomePage.name) {
            HomePage(navController = navController)
        }
        composable(
            NavigationScreen.DetailPage.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie")
            { type = NavType.StringType })
        ) { backStackEntry ->
            DetailPage(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
        composable(NavigationScreen.Login.name) {
            Login(navController = navController)
        }
        composable(NavigationScreen.Register.name) {
            Register(navController = navController)
        }

    }
}