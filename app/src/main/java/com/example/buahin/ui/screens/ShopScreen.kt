package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.components.*
import com.example.buahin.ui.theme.BuahinTheme

@Composable
fun ShopScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(
                rememberScrollState()
            ),
    ) {
        SearchBox()
        Spacer(modifier = Modifier.height(20.dp))
        Banner()
        Spacer(modifier = Modifier.height(30.dp))
        Section("Exclusive Offer")
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
            }
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
            }
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Section("Categories")
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            item {
                CategoryCard.Horizontal("Fruits")
            }
            item {
                CategoryCard.Horizontal("Vegetables")
            }
            item {
                CategoryCard.Horizontal("Meat & Fish")
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Section("Best Selling")
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
            }
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
            }
            item {
                ProductCard("Organic Banana", "7pcs, Price", "Rp. 14.500")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
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