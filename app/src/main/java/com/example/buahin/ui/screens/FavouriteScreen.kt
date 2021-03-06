/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * FavouriteScreen.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.buahin.ui.components.TopBar
import com.example.buahin.ui.components.FavouriteCard
import com.example.buahin.ui.components.ItemDivider
import com.example.buahin.ui.theme.*
import cz.levinzonr.saferoute.core.annotations.Route

@Route("favourite")
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