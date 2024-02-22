package com.example.newapplicationjetpackcompose.navigation

enum class NavigationScreen {
    HomePage,
    AccountPage,
    SearchPage,
    SplashScreen;

    fun fromRoute(route:String?): NavigationScreen =
        when(route?.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            HomePage.name -> HomePage
            AccountPage.name -> AccountPage
            SearchPage.name -> SearchPage
            null -> SplashScreen
            else -> throw IllegalArgumentException("Route $route is not a recognized")
        }

}