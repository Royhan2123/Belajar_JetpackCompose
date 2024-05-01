package com.example.jetpackcomposeapi.navigation

enum class NavigationScreen {
    SplashScreen,
    SignInScreen,
    SignUpScreen,
    SignUpSetPin,
    HomeScreen;

    fun fromRoute(route: String): NavigationScreen =
        when (route.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            SignUpScreen.name -> SignUpScreen
            SignInScreen.name -> SignInScreen
            SignUpSetPin.name -> SignUpSetPin
            HomeScreen.name -> HomeScreen

            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
}