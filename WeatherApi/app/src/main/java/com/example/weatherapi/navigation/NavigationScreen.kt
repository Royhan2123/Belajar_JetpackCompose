package com.example.weatherapi.navigation

enum class NavigationScreen {
    SplashScreen,
    HalamanBottom,
    Home,
    Search,
    Account;

    fun fromRoute(route:String) =
        when(route.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            HalamanBottom.name -> HalamanBottom
            Home.name -> Home
            Search.name -> Search
            Account.name -> Account
            else -> throw IllegalArgumentException("Route $route is not a recognized")
        }
}