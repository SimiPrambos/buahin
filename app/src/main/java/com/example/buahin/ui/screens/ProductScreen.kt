/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * ProductScreen.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buahin.R
import com.example.buahin.ui.components.ProductCard
import com.example.buahin.ui.components.TopBar
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.viewmodel.ProductsEvent
import com.example.buahin.viewmodel.ProductsViewModel
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import cz.levinzonr.saferoute.core.annotations.Route
import cz.levinzonr.saferoute.core.annotations.RouteArg

@Route(
    "products",
    [
        RouteArg(name = "id", isOptional = false),
        RouteArg(name = "name", isOptional = false),
    ]
)
@Composable
fun ProductScreen(navController: NavController, vm: ProductsViewModel = hiltViewModel()) {
    val state = vm.state.value

    LaunchedEffect(true) {
        vm.onEvent(ProductsEvent.Load)
    }

    Scaffold(
        topBar = {
            TopBar(
                title = state.title,
                onBackPressed = {
                    navController.popBackStack()
                },
                elevation = 0.dp,
                trailing = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_filter),
                            contentDescription = "",
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            FlowRow(
                mainAxisSize = SizeMode.Expand,
                mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
                crossAxisSpacing = 15.dp,
            ) {
                if (state.items.isEmpty()) {
                    repeat(10) {
                        ProductCard()
                    }
                } else {
                    state.items.forEach { item ->
                        ProductCard(
                            title = item.name,
                            subtitle = item.summary,
                            price = item.idr(),
                            thumbnail = item.thumbnail,
                        ) {
                            navController.navigateToProductDetail(item.id)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductScreenPreview() {
    BuahinTheme {
        ProductScreen(rememberNavController())
    }
}