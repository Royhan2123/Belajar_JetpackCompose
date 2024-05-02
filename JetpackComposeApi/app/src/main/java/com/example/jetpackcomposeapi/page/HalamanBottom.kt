package com.example.jetpackcomposeapi.page

import android.annotation.SuppressLint
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapi.ui.theme.blue
import com.example.jetpackcomposeapi.ui.theme.lightGray

sealed class BottomNavigationScreen(
    val title: String,
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector
) {
    data object HomeScreen : BottomNavigationScreen("Home", Icons.Filled.Home, Icons.Outlined.Home)
    data object SearchScreen :
        BottomNavigationScreen("History", Icons.Filled.Search, Icons.Outlined.Search)

    data object AccountScreen :
        BottomNavigationScreen("Account", Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle)

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HalamanBottom() {
    val navController = rememberNavController()

    val items = listOf(
        BottomNavigationScreen.HomeScreen,
        BottomNavigationScreen.SearchScreen,
        BottomNavigationScreen.AccountScreen,
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
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
                            val selectedIcon =
                                if (currentRoute == screen.title) screen.filledIcon else screen.outlinedIcon
                            Icon(
                                selectedIcon, contentDescription = screen.title,
                                tint = if (currentRoute == screen.title) blue else lightGray
                            )
                        },
                        label = {
                            Text(
                                text = screen.title,
                                color = if (currentRoute == screen.title)
                                    blue else lightGray
                            )
                        },
                        alwaysShowLabel = false
                    )
                }
            }
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = BottomNavigationScreen.HomeScreen.title
            ) {
                composable(BottomNavigationScreen.HomeScreen.title) {
                    HomeScreen(navController = navController)
                }
                composable(BottomNavigationScreen.SearchScreen.title) {
                    SearchScreen(navController = navController)
                }
                composable(BottomNavigationScreen.AccountScreen.title) {
                    AccountScreen(navController = navController)
                }
            }
        }
    )
}
