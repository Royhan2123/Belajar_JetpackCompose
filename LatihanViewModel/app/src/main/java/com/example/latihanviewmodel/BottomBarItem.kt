package com.example.latihanviewmodel

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
import com.example.latihanviewmodel.screen.Account
import com.example.latihanviewmodel.screen.HomePage
import com.example.latihanviewmodel.screen.Search
import com.example.latihanviewmodel.ui.theme.Cyan

sealed class BottomNavItem(
    var title: String,
    var icon: ImageVector,
    var routes: String,
) {
    object Home : BottomNavItem("Home", Icons.Rounded.Home, "home")
    object Search : BottomNavItem("Search", Icons.Rounded.Search, "Search")
    object Account : BottomNavItem("Account", Icons.Rounded.AccountCircle, "Account")
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.routes
    ) {
        composable(BottomNavItem.Home.routes) {
            HomePage(navController = navController)
        }
        composable(BottomNavItem.Search.routes) {
            Search(navController = navController)
        }
        composable(BottomNavItem.Account.routes) {
            Account(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Account,
    )
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoutes = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoutes == item.routes,
                onClick = {
                    navController.navigate(item.routes) {
                        navController.graph.startDestinationRoute?.let { screenRoutes ->
                            popUpTo(screenRoutes) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (currentRoutes == item.routes) Cyan else Color.LightGray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 13.sp,
                        color = if (currentRoutes == item.routes) Cyan else Color.LightGray
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanBottom(){
    val navController = rememberNavController()

    Scaffold (
        bottomBar = { BottomBar(navController = navController)}
    ) {
        NavigationGraph(navController = navController)
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewsHalamanBottom() {
    HalamanBottom()
}
