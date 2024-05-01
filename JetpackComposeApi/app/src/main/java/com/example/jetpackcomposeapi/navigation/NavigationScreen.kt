package com.example.jetpackcomposeapi.navigation

enum class NavigationScreen {
    SplashScreen,
    SignInScreen,
    SignUpScreen,
    HomeScreen;

    fun fromRoute(route: String): NavigationScreen =
        when (route.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            SignUpScreen.name -> SignUpScreen
            SignInScreen.name -> SignInScreen
            HomeScreen.name -> HomeScreen

            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
}