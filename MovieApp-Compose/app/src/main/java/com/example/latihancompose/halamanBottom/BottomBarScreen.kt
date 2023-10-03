package com.example.latihancompose.halamanBottom

import NavigationScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object HomePage : BottomBarScreen(
        route = NavigationScreen.HomePage.name,
        title = "Home",
        icon = Icons.Default.Home
    )

    object DetailPage : BottomBarScreen(
        route = NavigationScreen.DetailPage.name,
        title = "Home",
        icon = Icons.Default.Home
    )
}