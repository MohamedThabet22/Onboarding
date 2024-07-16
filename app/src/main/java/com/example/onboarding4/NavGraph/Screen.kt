package com.example.onboarding4.NavGraph

sealed  class Screen(
   val  route : String
) {

    object  Home : Screen(route="home")

    object Welcome : Screen(route = "welcome")
}