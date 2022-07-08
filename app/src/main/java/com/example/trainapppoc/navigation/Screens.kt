package com.example.trainapppoc.navigation

import java.lang.IllegalArgumentException

enum class Screens {
    HomeScreen,
    WebScreen;
    companion object {
        fun fromRoute(route: String?): Screens
         = when (route?.substringBefore("/")) {
             HomeScreen.name -> HomeScreen
            WebScreen.name -> WebScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
         }
    }
}