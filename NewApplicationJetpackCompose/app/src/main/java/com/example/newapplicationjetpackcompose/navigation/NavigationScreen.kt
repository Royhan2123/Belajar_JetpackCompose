package com.example.newapplicationjetpackcompose.navigation

enum class NavigationScreen {
    HomePage,
    AccountPage,
    SearchPage,
    SplashScreen,
    SignInPage,
    SignUpPage;

    fun fromRoute(route:String?): NavigationScreen =
        when(route?.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            HomePage.name -> HomePage
            AccountPage.name -> AccountPage
            SearchPage.name -> SearchPage
            SignInPage.name -> SignInPage
            SignUpPage.name -> SignUpPage
            null -> SplashScreen
            else -> throw IllegalArgumentException("Route $route is not a recognized")
        }
}