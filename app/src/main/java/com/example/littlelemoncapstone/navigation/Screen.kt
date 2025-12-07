package com.example.littlelemoncapstone.navigation

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Home : Screen("home")
    object Profile : Screen("profile")
}