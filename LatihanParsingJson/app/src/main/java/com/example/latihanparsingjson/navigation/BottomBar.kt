package com.example.latihanparsingjson.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.latihanparsingjson.page.AccountPage
import com.example.latihanparsingjson.page.HomePage

sealed class BottomNav(
    val title: String,
    val icon: ImageVector,
    val routing: String
) {
    object Home : BottomNav("Home", Icons.Rounded.Home, "home")
    object Account : BottomNav("Account", Icons.Rounded.AccountCircle, "account")
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNav.Home.routing) {
        composable(BottomNav.Home.routing) {
            HomePage(navController = navController)
        }
        composable(BottomNav.Account.routing) {
            AccountPage(navController = navController)
        }
    }
}

@Composable
fun Bottombar(navController: NavController) {
    val items = listOf(
        BottomNav.Home,
        BottomNav.Account,
    )

    val navCurrentByStack by navController.currentBackStackEntryAsState()
    val screenRoute = navCurrentByStack?.destination?.route
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                selected = screenRoute == item.routing,
                onClick = {
                    navController.navigate(item.routing) {
                        navController.graph.startDestinationRoute?.let { routes ->
                            popUpTo(routes) {
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
                        tint = if (screenRoute == item.routing) Color.Cyan else Color.Gray,
                        modifier = Modifier.size(22.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (screenRoute == item.routing) Color.Cyan else Color.Gray
                    )
                }
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HalamanBottom(){
    val navController = rememberNavController()
    Scaffold (
        bottomBar = { Bottombar(navController = navController)}
    ) {
        NavigationGraph(navController = navController)
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewsBottom(){
    HalamanBottom()
}