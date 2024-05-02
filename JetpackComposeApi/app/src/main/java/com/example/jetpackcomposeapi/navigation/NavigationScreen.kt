package com.example.jetpackcomposeapi.navigation

enum class NavigationScreen {
    SplashScreen,
    SignInScreen,
    SignUpScreen,
    SignUpSetPin,
    SignUpSetKtp,
    HalamanBottom,
    HomeScreen,
    SearchScreen,
    AccountScreen,
    CardDestination;

    fun fromRoute(route: String): NavigationScreen =
        when (route.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            SignUpScreen.name -> SignUpScreen
            SignInScreen.name -> SignInScreen
            SignUpSetPin.name -> SignUpSetPin
            SignUpSetKtp.name -> SignUpSetKtp
            SearchScreen.name -> SearchScreen
            HalamanBottom.name -> HalamanBottom
            AccountScreen.name -> AccountScreen
            HomeScreen.name -> HomeScreen
            CardDestination.name -> CardDestination

            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
}