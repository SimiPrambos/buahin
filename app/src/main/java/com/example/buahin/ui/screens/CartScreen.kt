package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.components.CartCard
import com.example.buahin.ui.components.TopBar
import com.example.buahin.ui.components.ItemDivider
import com.example.buahin.ui.components.RoundedButton
import com.example.buahin.ui.theme.BuahinTheme

@Composable
fun CartScreen() {
    Scaffold(
        topBar = { TopBar(title = "My Cart") },
        floatingActionButton = {
            RoundedButton.Filled(
                "Go to Checkout",
                onClick = {},
                modifier = Modifier.padding(bottom = 60.dp, start = 16.dp, end = 16.dp),
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            repeat(10) {
                CartCard()
                ItemDivider(0.dp)
            }
            Spacer(modifier = Modifier.height(200.dp))
        }
    }
}

@Preview
@Composable
fun CartScreenPreview() {
    BuahinTheme {
        CartScreen()
    }
}
