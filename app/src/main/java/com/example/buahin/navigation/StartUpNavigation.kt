package com.example.buahin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buahin.ui.screens.OnboardingScreen
import com.example.buahin.ui.screens.Routes

fun NavGraphBuilder.StartUpNavigation(navController: NavController, route: String) {
    navigation(route = route, startDestination = Routes.Onboarding.route) {
        composable(Routes.Onboarding.route) {
            OnboardingScreen(navController)
        }
    }
}