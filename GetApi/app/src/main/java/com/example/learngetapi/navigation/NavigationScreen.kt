package com.example.learngetapi.navigation

enum class NavigationScreen {
    SignInScreen,
    SplashScreen;

    fun fromRoute(route:String?) : NavigationScreen =
        when(route?.substringBefore("/")) {
            SignInScreen.name -> SignInScreen
            SplashScreen.name -> SplashScreen
            else -> throw  IllegalArgumentException("route $route is not a recognized")
        }
}