package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.navigation.Navigation
import com.example.buahin.ui.components.ItemDivider
import com.example.buahin.ui.components.ListItem
import com.example.buahin.ui.components.ProfileCard
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Typography
import cz.levinzonr.saferoute.core.annotations.Route

@Route("account")
@Composable
fun AccountScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ProfileCard()
        ItemDivider(0.dp)
        Navigation.SETTINGS.forEach { setting ->
            ListItem(
                icon = setting.icon,
                title = setting.label,
                onClick = {}
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
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