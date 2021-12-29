/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * ExploreScreen.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buahin.ui.components.CategoryCard
import com.example.buahin.ui.components.SearchBox
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Typography
import com.example.buahin.viewmodel.ExploreEvent
import com.example.buahin.viewmodel.ExploreViewModel
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import cz.levinzonr.saferoute.core.annotations.Route

@Route("explore")
@Composable
fun ExploreScreen(navController: NavController, vm: ExploreViewModel = hiltViewModel()) {
    val state = vm.state.value

    LaunchedEffect(true) {
        vm.onEvent(ExploreEvent.Load)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Find Products",
            style = Typography.h6,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(30.dp))
        SearchBox()
        Spacer(modifier = Modifier.height(20.dp))
        FlowRow(
            mainAxisSize = SizeMode.Expand,
            mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
            crossAxisSpacing = 15.dp,
        ) {
            if (state.categories.isEmpty())
                repeat(4) {
                    CategoryCard.Vertical()
                }
            else
                state.categories.forEach { item ->
                    CategoryCard.Vertical(title = item.name, item.thumbnail) {
                        navController.navigateToProducts(
                            id = item.id,
                            name = item.name,
                        )
                    }
                }
        }
    }
}

@Preview
@Composable
fun ExploreScreenPreview() {
    BuahinTheme {
        Scaffold {
            ExploreScreen(rememberNavController())
        }
    }
}