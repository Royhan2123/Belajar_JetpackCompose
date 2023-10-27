package com.example.latihanviewmodel.navigation

import androidx.compose.runtime.Composable

enum class NavigationSreen  {
    SplashScreen,
    HomePage,
    Search,
    Account,
    HalamanBottom;

    fun fromRoute(route:String) =
        when (route.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            HomePage.name -> HomePage
            Search.name -> Search
            Account.name -> Account
            HalamanBottom.name -> HalamanBottom
            else -> throw IllegalArgumentException("Route $route is not a recognized")
        }
}