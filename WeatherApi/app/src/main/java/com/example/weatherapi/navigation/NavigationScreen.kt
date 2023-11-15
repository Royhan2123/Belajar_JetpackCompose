package com.example.weatherapi.navigation

enum class NavigationScreen {
    SplashScreen,
    SplashScreen2,
    HalamanBottom,
    HomePage,
    Search,
    Account;

    fun fromRoute(route:String) : NavigationScreen
    = when(route.substringBefore("/")){
        SplashScreen.name -> SplashScreen
        SplashScreen2.name -> SplashScreen2
        HalamanBottom.name -> HalamanBottom
        HomePage.name -> HomePage
        Search.name -> Search
        Account.name -> Account
        else -> throw IllegalArgumentException("Route $route is not a recognized")
    }
}