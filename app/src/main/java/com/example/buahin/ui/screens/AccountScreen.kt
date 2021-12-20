package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.config.AppNavigation
import com.example.buahin.ui.components.ItemDivider
import com.example.buahin.ui.components.ListItem
import com.example.buahin.ui.components.ProfileCard
import com.example.buahin.ui.components.RoundedButton
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Typography

@Composable
fun AccountScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        ProfileCard()
        ItemDivider(0.dp)
        LazyColumn {
            AppNavigation.settings.forEach { setting ->
                item {
                    ListItem(
                        icon = setting.icon,
                        title = setting.label,
                        onClick = {}
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Logout",
            style = Typography.button,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
fun AccountScreenPreview() {
    BuahinTheme {
        Scaffold {
            AccountScreen()
        }
    }
}