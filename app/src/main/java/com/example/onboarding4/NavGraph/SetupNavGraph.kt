package com.example.onboarding4.NavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onboarding.screen.HomeScreen
import com.example.onboarding4.mvvm.MainViewModel
import com.example.onboarding4.screen.WelcomeScreen

@Composable
fun  SetupNavGraph(
    NavControl : NavHostController,
    startDestination: String = Screen.Welcome.route,
    viewModel: MainViewModel
){

    NavHost(navController = NavControl, startDestination =  startDestination) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(NavControl,viewModel)
        }
        composable(route = Screen.Home.route) {
            HomeScreen()
        }

    }



}
