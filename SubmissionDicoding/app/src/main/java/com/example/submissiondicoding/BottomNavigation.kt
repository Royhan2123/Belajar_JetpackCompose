package com.example.submissiondicoding

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Details
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationApp(
) {
    val navController = rememberNavController()
    val items = listOf(
        NavigationScreen.Home,
        NavigationScreen.Account
    )

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.Home.title
    ) {
        composable(NavigationScreen.Home.title) {
            Home(navController = navController)
        }
        composable(NavigationScreen.Account.title) {
            Account(navController = navController)
        }
    }

    Scaffold (
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            when (screen) {
                                NavigationScreen.Home -> Icon(Icons.Default.Home, contentDescription = "Home")
                                NavigationScreen.Account -> Icon(Icons.Default.AccountCircle, contentDescription = "Account")
                                else -> throw  IllegalArgumentException("Screen $screen is not a recognized")
                            }
                        },
                        label = { Text(text = screen.title) },
                        selected = currentRoute == screen.title,
                        onClick = {
                            navController.navigate(screen.title) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) {

    }
}

@Preview
@Composable
fun PreviewBottom(){
    BottomNavigationApp(

    )
}

sealed class NavigationScreen(val title: String) {
    object Home : NavigationScreen("Home")
    object Detail : NavigationScreen("Detail")
    object Account : NavigationScreen("Account")
    object BottomNavigation : NavigationScreen("BottomNavigation")
}
