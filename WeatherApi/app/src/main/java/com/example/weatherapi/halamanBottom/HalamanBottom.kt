package com.example.weatherapi.halamanBottom

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weatherapi.page.Account
import com.example.weatherapi.page.Home
import com.example.weatherapi.page.Search


sealed class BottomNav(
    val icon: ImageVector,
    val title: String,
    val routes: String
) {
    object Home : BottomNav(icon = Icons.Rounded.Home, title = "Home", "home")
    object Search : BottomNav(icon = Icons.Rounded.Search, title = "Search", "search")
    object Account : BottomNav(icon = Icons.Rounded.AccountCircle, title = "Account", "account")
}

@Composable
fun NavigationGraph(navcontroller: NavHostController) {
    NavHost(navController = navcontroller, startDestination = BottomNav.Home.routes) {
        composable(BottomNav.Home.routes) {
            Home(navController = navcontroller)
        }
        composable(BottomNav.Search.routes) {
            Search(navController = navcontroller)
        }
        composable(BottomNav.Account.routes) {
            Account(navController = navcontroller)
        }
    }
}

    @Composable
    fun BottomBar(navController: NavController) {
        val items = listOf(
            BottomNav.Home,
            BottomNav.Search,
            BottomNav.Account,
        )
        BottomNavigation(
            backgroundColor = Color.White
        ) {
            val navBackStateEntry by navController.currentBackStackEntryAsState()
            val screenRoute = navBackStateEntry?.destination?.route

            items.forEach { item ->
                BottomNavigationItem(
                    selected = item.routes == screenRoute,
                    onClick = {
                        navController.navigate(item.routes) {
                            navController.graph.startDestinationRoute?.let { currentRoutes ->
                                popUpTo(currentRoutes) {
                                    saveState = true
                                }
                                restoreState = true
                                launchSingleTop = true
                            }
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon, contentDescription = item.title,
                            tint = if (item.routes == screenRoute)Color.Cyan else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 13.sp,
                            color = if (item.routes == screenRoute)Color.Cyan else Color.Gray
                        )
                    }
                )
            }
        }
    }

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanBottom() {
    val navcontroller = rememberNavController()
    Scaffold (
        bottomBar = { BottomBar(navController = navcontroller)}
    ) {
        NavigationGraph(navcontroller = navcontroller)
    }
}

@Preview
@Composable
fun PreviewssBottom(){
    HalamanBottom()
}