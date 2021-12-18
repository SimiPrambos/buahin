package com.example.buahin.config

import com.example.buahin.R

sealed class AppNavigation(val route: String) {
    open class Bottom(val label: String, val icon: Int, route: String) : AppNavigation(route)

    object Shop : Bottom("Shop", R.drawable.ic_shop, "/shop")
    object Explore : Bottom("Explore", R.drawable.ic_explore, "/explore")
    object Cart : Bottom("Cart", R.drawable.ic_cart, "/cart")
    object Favourite : Bottom("Favourite", R.drawable.ic_favourite, "/favourite")
    object Account : Bottom("Account", R.drawable.ic_account, "/account")

    companion object {
        val bottom = listOf<Bottom>(
            Shop,
            Explore,
            Cart,
            Favourite,
            Account
        )
    }
}