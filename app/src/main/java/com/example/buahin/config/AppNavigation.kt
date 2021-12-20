package com.example.buahin.config

import com.example.buahin.R

sealed class AppNavigation(val route: String) {
    open class AppNavigationIcon(val label: String, val icon: Int, route: String) :
        AppNavigation(route)

    object Shop : AppNavigationIcon("Shop", R.drawable.ic_shop, "/shop")
    object Explore : AppNavigationIcon("Explore", R.drawable.ic_explore, "/explore")
    object Cart : AppNavigationIcon("Cart", R.drawable.ic_cart, "/cart")
    object Favourite : AppNavigationIcon("Favourite", R.drawable.ic_favourite, "/favourite")
    object Account : AppNavigationIcon("Account", R.drawable.ic_account, "/account")

    object Orders : AppNavigationIcon("Orders", R.drawable.ic_orders, "/orders")
    object Address : AppNavigationIcon("Delivery Address", R.drawable.ic_address, "/address")
    object Payment : AppNavigationIcon("Payment Methods", R.drawable.ic_payment, "/payment-methods")
    object Promo : AppNavigationIcon("Promo Card", R.drawable.ic_promo, "/promo")
    object Notification :
        AppNavigationIcon("Notification", R.drawable.ic_notification, "/notification")

    object Help : AppNavigationIcon("Help", R.drawable.ic_help, "/help")
    object About : AppNavigationIcon("About", R.drawable.ic_about, "/about")

    companion object {
        val bottom = listOf<AppNavigationIcon>(
            Shop,
            Explore,
            Cart,
            Favourite,
            Account
        )
        val settings = listOf<AppNavigationIcon>(
            Orders,
            Address,
            Payment,
            Promo,
            Notification,
            Help,
            About,
        )
    }
}