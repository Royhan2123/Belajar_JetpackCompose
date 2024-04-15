package com.example.learngetapi.navigation

enum class NavigationScreen {
    SplashScreen,
    HomeScreen;

    fun fromRoute(route:String?) : NavigationScreen =
        when(route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            HomeScreen.name -> HomeScreen
            else -> throw  IllegalArgumentException("route $route is not a recognized")
        }
}