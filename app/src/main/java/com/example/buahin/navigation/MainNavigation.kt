package com.example.buahin.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buahin.ui.screens.*

@ExperimentalMaterialApi
fun NavGraphBuilder.MainNavigation(navController: NavController, route: String) {
    navigation(route = route, startDestination = Routes.Shop.route) {
        composable(Routes.Shop.route) {
            ShopScreen(navController)
        }
        composable(Routes.Explore.route) {
            ExploreScreen(navController)
        }
        composable(Routes.Cart.route) {
            CartScreen()
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
    }
}