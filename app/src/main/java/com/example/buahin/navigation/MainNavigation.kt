/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * MainNavigation.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buahin.ui.screens.*

val MAIN_START_DESTINATION = Routes.Shop.route

@ExperimentalMaterialApi
fun NavGraphBuilder.MainNavigation(navController: NavController, route: String) {
    navigation(route = route, startDestination = MAIN_START_DESTINATION) {
        composable(Routes.Shop.route) {
            ShopScreen(navController)
        }
        composable(Routes.Explore.route) {
            ExploreScreen(navController)
        }
        composable(Routes.Cart.route) {
            CartScreen(navController)
        }
        composable(Routes.Favourite.route) {
            FavouriteScreen()
        }
        composable(Routes.Account.route) {
            AccountScreen(navController)
        }
        composable(Routes.Products.route) {
            ProductScreen(navController)
        }
        composable(Routes.ProductDetail.route) {
            ProductDetailScreen(navController)
        }
        composable(Routes.Order.route) {
            OrderScreen(navController)
        }
        composable(Routes.Orders.route) {
            OrdersScreen(navController)
        }
    }
}

fun NavController.popToMain() {
    popBackStack(MAIN_START_DESTINATION, inclusive = false)
}
