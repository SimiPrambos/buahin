package com.example.buahin.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buahin.ui.components.CategoryCard
import com.example.buahin.ui.components.SearchBox
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Typography
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import cz.levinzonr.saferoute.core.annotations.Route

@Route("explore")
@Composable
fun ExploreScreen() {
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
            CategoryCard.Vertical(title = "Buah dan Sayur")
            CategoryCard.Vertical(title = "Buah dan Sayur")
            CategoryCard.Vertical(title = "Buah dan Sayur")
            CategoryCard.Vertical(title = "Buah dan Sayur")
        }
    }
}

@Preview
@Composable
fun ExploreScreenPreview() {
    BuahinTheme {
        Scaffold {
            ExploreScreen()
        }
    }
}