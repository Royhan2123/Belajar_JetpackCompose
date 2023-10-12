package com.example.latihancompose.ui

enum class NavigationScreen {
    Login,
    Register,
    SplashScreen,
    HomePage,
    DetailPage,
    Account;

    fun fromRoute(route:String?) : NavigationScreen =
        when(route?.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            Register.name -> Register
            HomePage.name -> HomePage
            DetailPage.name -> DetailPage
            Account.name -> Account
            Login.name -> Login
            null -> SplashScreen
            else -> throw IllegalArgumentException("Route $route is not a recognized")
        }
}