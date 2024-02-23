package com.example.newapplicationjetpackcompose

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newapplicationjetpackcompose.page.AccountPage
import com.example.newapplicationjetpackcompose.page.HomePage
import com.example.newapplicationjetpackcompose.page.SearchPage
import com.example.newapplicationjetpackcompose.ui.theme.Cyan


sealed class NavigationsScreen(val title: String) {
    object HomePage : NavigationsScreen("Home")
    object SearchPage : NavigationsScreen("Detail")
    object AccountPage : NavigationsScreen("Account")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanBottom() {
    val navController = rememberNavController()
    val items = listOf(
        NavigationsScreen.HomePage,
        NavigationsScreen.SearchPage,
        NavigationsScreen.AccountPage,
    )
    NavHost(
        navController = navController,
        startDestination = NavigationsScreen.HomePage.title
    ) {
        composable(NavigationsScreen.HomePage.title) {
            HomePage(navController = navController)
        }
        composable(NavigationsScreen.SearchPage.title) {
            SearchPage(navController = navController)
        }
        composable(NavigationsScreen.AccountPage.title) {
            AccountPage(navController = navController)
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigation (
                backgroundColor = Color.White,
                elevation = 10.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentRoute == screen.title,
                        onClick = {
                            navController.navigate(screen.title) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            when (screen) {
                                NavigationsScreen.HomePage -> Icon(
                                    Icons.Default.Home,
                                    contentDescription = "Home"
                                )

                                NavigationsScreen.SearchPage -> Icon(
                                    Icons.Default.Search,
                                    contentDescription = "Search"
                                )

                                NavigationsScreen.AccountPage -> Icon(
                                    Icons.Default.AccountCircle,
                                    contentDescription = "Account"
                                )
                            }
                        },
                        label = {
                            Text(text = screen.title,
                                color = if (currentRoute == screen.title)
                                    Cyan else Color.Gray)
                        },
                        selectedContentColor = Cyan,
                        unselectedContentColor = Color.Gray,)
                }
            }
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = NavigationsScreen.HomePage.title
            ) {
                composable(NavigationsScreen.HomePage.title) {
                    HomePage(navController = navController)
                }
                composable(NavigationsScreen.SearchPage.title) {
                    SearchPage(navController = navController)
                }
                composable(NavigationsScreen.AccountPage.title) {
                    AccountPage(navController = navController)
                }
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewBottomNavigation() {
    HalamanBottom()
}