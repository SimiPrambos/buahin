package com.example.buahin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buahin.ui.screens.Routes
import com.example.buahin.ui.screens.SignInScreen
import com.example.buahin.ui.screens.SignUpScreen

fun NavGraphBuilder.AuthNavigation(navController: NavController, route: String) {
    navigation(route = route, startDestination = Routes.SignIn.route) {
        composable(Routes.SignIn.route) {
            SignInScreen(navController)
        }

        composable(Routes.SignUp.route) {
            SignUpScreen(navController)
        }
    }
}