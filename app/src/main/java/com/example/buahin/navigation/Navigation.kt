package com.example.buahin.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.buahin.R
import com.example.buahin.ui.screens.Routes
import com.example.buahin.ui.theme.Dark
import com.example.buahin.ui.theme.Primary
import com.example.buahin.ui.theme.Typography

class Navigation(private val navController: NavHostController) {
    data class Menu(val label: String, val icon: Int, val route: String)

    companion object {
        const val ROOT_ROUTE = "root"
        const val STARTUP_ROUTE = "startup"
        const val AUTH_ROUTE = "auth"
        const val MAIN_ROUTE = "main"
        val BOTTOMS = listOf(
            Menu("Shop", R.drawable.ic_shop, Routes.Shop.route),
            Menu("Explore", R.drawable.ic_explore, Routes.Explore.route),
            Menu("Cart", R.drawable.ic_cart, Routes.Cart.route),
            Menu("Favourite", R.drawable.ic_favourite, Routes.Favourite.route),
            Menu("Account", R.drawable.ic_account, Routes.Account.route),
        )
        val SETTINGS = listOf(
            Menu("Orders", R.drawable.ic_orders, Routes.Orders.route),
            Menu("Delivery Address", R.drawable.ic_address, ""),
            Menu("Payment Method", R.drawable.ic_payment, ""),
            Menu("Promo Card", R.drawable.ic_promo, ""),
            Menu("Notification", R.drawable.ic_notification, ""),
            Menu("Help", R.drawable.ic_help, ""),
            Menu("About", R.drawable.ic_about, ""),
        )
    }

    @ExperimentalMaterialApi
    @Composable
    fun Build(initialRoute: String = STARTUP_ROUTE) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val showBottomBar = BOTTOMS.any { it.route == currentRoute }

        Scaffold(
            bottomBar = {
                if (showBottomBar)
                    BottomNavigation(backgroundColor = Color.White) {
                        BOTTOMS.forEach { item ->
                            val selected = currentRoute == item.route
                            BottomNavigationItem(
                                selected = selected,
                                onClick = {
                                    navController.navigate(item.route) {
                                        navController.graph.startDestinationRoute?.let { route ->
                                            popUpTo(route) { saveState = true }
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        painter = painterResource(id = item.icon),
                                        contentDescription = item.label,
                                        modifier = Modifier.size(24.dp),
                                    )
                                },
                                label = {
                                    Text(
                                        text = item.label,
                                        style = Typography.caption,
                                        fontWeight = FontWeight.SemiBold,
                                        color = if (selected) Primary else Dark,
                                        fontSize = 11.sp,
                                    )
                                },
                                selectedContentColor = Primary,
                                unselectedContentColor = Dark,
                            )
                        }
                    }
            }
        ) {
            Box(modifier = Modifier.padding(it)) {
                NavHost(
                    navController = navController,
                    route = ROOT_ROUTE,
                    startDestination = initialRoute,
                ) {
                    StartUpNavigation(navController, STARTUP_ROUTE)
                    AuthNavigation(navController, AUTH_ROUTE)
                    MainNavigation(navController, MAIN_ROUTE)
                }
            }
        }
    }
}