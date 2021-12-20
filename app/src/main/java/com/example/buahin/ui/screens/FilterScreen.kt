package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.R
import com.example.buahin.ui.components.CheckboxValue
import com.example.buahin.ui.components.MultipleCheckbox
import com.example.buahin.ui.components.Section
import com.example.buahin.ui.components.TopBar
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Grey200

@Composable
fun FilterScreen() {
    val categories = remember {
        mutableStateMapOf(
            "1" to CheckboxValue("Eggs", true),
            "2" to CheckboxValue("Noodles & Pasta", false),
            "3" to CheckboxValue("Chips & Crisps", true),
            "4" to CheckboxValue("Fast Foods", false),
        )
    }
    val brands = remember {
        mutableStateMapOf(
            "1" to CheckboxValue("Coke", false),
            "2" to CheckboxValue("Sprite", false),
            "3" to CheckboxValue("Coca Cola", true),
            "4" to CheckboxValue("Pepsi", false),
        )
    }

    Scaffold(
        topBar = {
            TopBar(
                title = "Filters",
                backIcon = R.drawable.ic_close,
                onBackPressed = {},
                elevation = 0.dp,
            )
        }
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                backgroundColor = Grey200,
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Section(title = "Categories", showMore = false)
                    Spacer(modifier = Modifier.height(16.dp))
                    MultipleCheckbox(
                        items = categories.toMap(),
                        onItemCheckedChange = { key, value ->
                            categories[key] = value
                        }
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Section(title = "Brands", showMore = false)
                    Spacer(modifier = Modifier.height(16.dp))
                    MultipleCheckbox(
                        items = brands.toMap(),
                        onItemCheckedChange = { key, value ->
                            brands[key] = value
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun FilterScreenPreview() {
    BuahinTheme {
        FilterScreen()
    }
}