package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.components.FavouriteCard
import com.example.buahin.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun FavouriteScreen() {
    Scaffold(
        topBar = { CenteredTopBar(title = "Favourite") },
    ) {
        LazyColumn() {
            repeat(10) {
                item {
                    FavouriteCard()
                    Divider(color = Grey300, modifier = Modifier.padding(horizontal = 20.dp))
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun FavouriteScreenPreview() {
    BuahinTheme {
        FavouriteScreen()
    }
}