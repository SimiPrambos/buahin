package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.components.*
import com.example.buahin.ui.theme.BuahinTheme
import cz.levinzonr.saferoute.core.annotations.Route

@Route("shop")
@Composable
fun ShopScreen() {
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
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
            }
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
            }
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
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
            item {
                CategoryCard.Horizontal("Fruits")
            }
            item {
                CategoryCard.Horizontal("Vegetables")
            }
            item {
                CategoryCard.Horizontal("Meat & Fish")
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
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
            }
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
            }
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
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