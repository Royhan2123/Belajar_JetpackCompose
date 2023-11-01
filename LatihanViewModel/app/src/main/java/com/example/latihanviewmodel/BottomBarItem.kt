package com.example.latihanviewmodel

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

sealed class BottomBarItem(
    val icon: ImageVector,
    val title: String,
    val routes: String
) {
    object Home : BottomBarItem(icon = Icons.Rounded.Home, "Home", "home")
    object Search : BottomBarItem(icon = Icons.Rounded.Search, "Search", "search")
    object Account : BottomBarItem(icon = Icons.Rounded.AccountCircle, "Account", "account")
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItem.Home.routes
    ) {
        composable(BottomBarItem.Home.routes) {
            HomePage(navController = navController)
        }
        composable(BottomBarItem.Search.routes) {
            Search(navController = navController)
        }
        composable(BottomBarItem.Account.routes) {
            Account(navController = navController)
        }
    }
}

@Composable
fun BottomBars(navController: NavController) {
    val items = listOf(
        BottomBarItem.Home,
        BottomBarItem.Search,
        BottomBarItem.Account,
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
                        navController.graph.startDestinationRoute?.let { routing ->
                            popUpTo(routing) {
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
                        tint = if (screenRoute == item.routes) Cyan else Color.Gray,
                        modifier = Modifier.size(22.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (screenRoute == item.routes) Cyan else Color.Gray,
                    )
                },
            )
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanBottom() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBars(navController = navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewsHalamanBottom() {
    HalamanBottom()
}
