package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.components.OrderCard
import com.example.buahin.ui.components.TopBar
import com.example.buahin.ui.theme.BuahinTheme
import cz.levinzonr.saferoute.core.annotations.Route

@Route("orders")
@Composable
fun OrdersScreen() {
    Scaffold(
        topBar = {
            TopBar(
                title = "My Orders",
                onBackPressed = {},
            )
        }
    ) {
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                OrderCard(
                    date = "28-12-2021 10:30",
                    title = "My Products",
                    subtitle = "120 gr/pack",
                    status = "Completed",
                    qty = 3,
                    subtotal = "Rp xxx.xxx",
                    count = 4,
                    total = "Rp xxx.xxx",
                )
            }
        }
    }
}

@Preview
@Composable
fun OrdersScreenPreview() {
    BuahinTheme {
        OrdersScreen()
    }
}