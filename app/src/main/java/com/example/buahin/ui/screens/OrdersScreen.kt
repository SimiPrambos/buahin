package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buahin.ui.components.OrderCard
import com.example.buahin.ui.components.TopBar
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.viewmodel.OrdersEvent
import com.example.buahin.viewmodel.OrdersViewModel
import cz.levinzonr.saferoute.core.annotations.Route

@Route("orders")
@Composable
fun OrdersScreen(navController: NavController, vm: OrdersViewModel = hiltViewModel()) {
    val state = vm.state.value

    LaunchedEffect(true) {
        vm.onEvent(OrdersEvent.Load)
    }

    Scaffold(
        topBar = {
            TopBar(
                title = "My Orders",
                onBackPressed = {
                    navController.popBackStack()
                },
            )
        }
    ) {
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            items(state.items.size) {
                val order = state.items[it]
                Spacer(modifier = Modifier.height(16.dp))
                OrderCard(
                    date = order.createdAtHumanize,
                    title = order.details.first().product.name,
                    subtitle = order.details.first().product.summary,
                    thumbnail = order.details.first().product.thumbnail,
                    status = order.status,
                    qty = order.details.first().qty,
                    subtotal = order.details.first().subtotalIdr(),
                    count = order.details.size,
                    total = order.totalIdr,
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun OrdersScreenPreview() {
    BuahinTheme {
        OrdersScreen(rememberNavController())
    }
}