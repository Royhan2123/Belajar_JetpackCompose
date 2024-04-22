package com.example.learngetapi.navigation

enum class NavigationScreen {
    HomeScreen;

    fun fromRoute(route:String?) : NavigationScreen =
        when(route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            else -> throw  IllegalArgumentException("route $route is not a recognized")
        }
}