/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * StartUpNavigation.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buahin.ui.screens.OnboardingScreen
import com.example.buahin.ui.screens.Routes
import com.example.buahin.ui.screens.SplashScreen

val START_UP_START_DESTINATION = Routes.SplashScreen.route

fun NavGraphBuilder.StartUpNavigation(navController: NavController, route: String) {
    navigation(route = route, startDestination = START_UP_START_DESTINATION) {
        composable(Routes.Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(Routes.SplashScreen.route) {
            SplashScreen()
        }
    }
}

fun NavController.popToStartUp() {
    popBackStack(START_UP_START_DESTINATION, inclusive = false)
}