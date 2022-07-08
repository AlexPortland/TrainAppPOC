package com.example.trainapppoc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.trainapppoc.screens.home.HomeScreen
import com.example.trainapppoc.screens.web.WebScreen

@Composable
fun ScrNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HomeScreen.name){
        composable(Screens.HomeScreen.name){
            HomeScreen(navController = navController)
        }
        composable(Screens.WebScreen.name+"/{time}/{direction}",
            arguments = listOf(
                navArgument(name = "time"){type = NavType.LongType},
                navArgument(name = "direction"){type = NavType.StringType})){
            backStackEntry ->

            WebScreen(
                navController = navController,
                backStackEntry.arguments?.getLong("time"),
                backStackEntry.arguments?.getString("direction"))
        }
    }
}