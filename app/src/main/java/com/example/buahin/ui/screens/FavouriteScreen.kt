package com.example.buahin.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.buahin.ui.components.TopBar
import com.example.buahin.ui.components.FavouriteCard
import com.example.buahin.ui.components.ItemDivider
import com.example.buahin.ui.theme.*

@Composable
fun FavouriteScreen() {
    Scaffold(
        topBar = { TopBar(title = "Favourite") },
    ) {
        LazyColumn() {
            repeat(10) {
                item {
                    FavouriteCard()
                    ItemDivider()
                }
            }
        }
    }
}

@Preview
@Composable
fun FavouriteScreenPreview() {
    BuahinTheme {
        FavouriteScreen()
    }
}