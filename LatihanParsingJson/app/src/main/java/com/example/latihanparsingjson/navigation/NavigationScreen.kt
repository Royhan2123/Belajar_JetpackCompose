package com.example.latihanparsingjson.navigation

enum class NavigationScreen {
    HalamanBottom,
    HomePage,
    AccountPage;

    fun fromRoute(route:String):NavigationScreen
    = when(route.substringBefore("/")){
        HalamanBottom.name -> HalamanBottom
        HomePage.name -> HomePage
        AccountPage.name -> AccountPage
        else -> throw IllegalArgumentException("Route $route is not a recognized")
    }
}