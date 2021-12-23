package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.R
import com.example.buahin.ui.components.ProductCard
import com.example.buahin.ui.components.TopBar
import com.example.buahin.ui.theme.BuahinTheme
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import cz.levinzonr.saferoute.core.annotations.Route

@Route("product")
@Composable
fun ProductScreen() {
    Scaffold(
        topBar = {
            TopBar(
                title = "Baverages",
                onBackPressed = {},
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
                repeat(10) {
                    ProductCard(
                        title = "Orange Juice",
                        subtitle = "2L, Price",
                        price = "Rp. 15.000",
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductScreenPreview() {
    BuahinTheme {
        ProductScreen()
    }
}