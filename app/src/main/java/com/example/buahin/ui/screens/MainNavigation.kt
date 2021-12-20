package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.buahin.config.AppNavigation
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Dark
import com.example.buahin.ui.theme.Primary
import com.example.buahin.ui.theme.Typography

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = Color.White) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                AppNavigation.bottom.forEach { item ->
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
        NavHost(navController = navController, startDestination = AppNavigation.Shop.route) {
            composable(AppNavigation.Shop.route) {
                ShopScreen()
            }
            composable(AppNavigation.Explore.route) {
                ExploreScreen()
            }
            composable(AppNavigation.Cart.route) {
                CartScreen()
            }
            composable(AppNavigation.Favourite.route) {
                FavouriteScreen()
            }
            composable(AppNavigation.Account.route) {
                AccountScreen()
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun MainNavigationPreview() {
    BuahinTheme {
        MainNavigation()
    }
}