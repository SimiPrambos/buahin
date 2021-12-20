package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.components.CartCard
import com.example.buahin.ui.components.CenteredTopBar
import com.example.buahin.ui.components.ItemDivider
import com.example.buahin.ui.theme.BuahinTheme

@Composable
fun CartScreen() {
    Scaffold(topBar = { CenteredTopBar(title = "My Cart") }) {
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            repeat(5) {
                item {
                    CartCard()
                    ItemDivider()
                }
            }
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
