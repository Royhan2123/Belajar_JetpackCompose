package com.example.submissiondicoding.navigation

import java.lang.IllegalArgumentException


enum class NavigationScreen {
    SplashScreen,
    Home,
    Detail,
    Account;

    fun fromRoute(route: String?) =
        when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            Home.name -> Home
            Detail.name -> Detail
            Account.name -> Account

            null -> SplashScreen.name
            else -> throw IllegalArgumentException("Route $route not is a recognized")
        }
}