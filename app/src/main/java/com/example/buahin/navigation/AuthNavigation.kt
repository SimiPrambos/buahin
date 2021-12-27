package com.example.buahin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buahin.ui.screens.Routes
import com.example.buahin.ui.screens.SignInScreen
import com.example.buahin.ui.screens.SignUpScreen

val AUTH_START_DESTINATION = Routes.SignIn.route

fun NavGraphBuilder.AuthNavigation(navController: NavController, route: String) {
    navigation(route = route, startDestination = AUTH_START_DESTINATION) {
        composable(Routes.SignIn.route) {
            SignInScreen(navController)
        }

        composable(Routes.SignUp.route) {
            SignUpScreen(navController)
        }
    }
}

fun NavController.popToAuth() {
    popBackStack(AUTH_START_DESTINATION, inclusive = false)
}