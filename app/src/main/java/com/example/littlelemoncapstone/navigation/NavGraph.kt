package com.example.littlelemoncapstone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemoncapstone.data.UserPreferences
import com.example.littlelemoncapstone.home.HomeScreen
import com.example.littlelemoncapstone.onboarding.OnboardingScreen
import com.example.littlelemoncapstone.profile.ProfileScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val userPrefs = UserPreferences(context)
    val onboardingDone by userPrefs.onboardingCompleted.collectAsState(initial = false)

    val startRoute = if (onboardingDone) Screen.Home.route else Screen.Onboarding.route

    NavHost(
        navController = navController,
        startDestination = startRoute
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}