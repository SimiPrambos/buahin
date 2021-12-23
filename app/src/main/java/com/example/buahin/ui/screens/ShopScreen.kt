package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.buahin.ui.components.*
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.viewmodel.ShopEvent
import com.example.buahin.viewmodel.ShopViewModel
import cz.levinzonr.saferoute.core.annotations.Route

@Route("shop")
@Composable
fun ShopScreen(vm: ShopViewModel = hiltViewModel()) {
    val state = vm.state.value

    LaunchedEffect(true) {
        vm.onEvent(ShopEvent.LoadOffer)
        vm.onEvent(ShopEvent.LoadCategory)
        vm.onEvent(ShopEvent.LoadBestSeller)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        SearchBox(modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp))
        Banner(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Section(
            "Exclusive Offer",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            item { }
            items(state.offers.size) { index ->
                val item = state.offers[index]
                ProductCard(item.name, item.summary, "Rp. ${item.price}")
            }
            item { }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Section(
            "Categories",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            item { }
            items(state.categories.size) { index ->
                val item = state.categories[index]
                CategoryCard.Horizontal(item.name)
            }
            item { }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Section(
            "Best Selling",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            item { }
            items(state.bestSeller.size) { index ->
                val item = state.bestSeller[index]
                ProductCard(item.name, item.summary, "Rp. ${item.price}")
            }
            item { }
        }
    }
}

@Preview
@Composable
fun ShopScreenPreview() {
    BuahinTheme {
        Scaffold {
            ShopScreen()
        }
    }
}