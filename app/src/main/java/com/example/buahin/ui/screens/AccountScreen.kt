/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * AccountScreen.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buahin.navigation.Navigation
import com.example.buahin.ui.components.ItemDivider
import com.example.buahin.ui.components.ListItem
import com.example.buahin.ui.components.ProfileCard
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Typography
import com.example.buahin.viewmodel.AuthEvent
import com.example.buahin.viewmodel.AuthState
import com.example.buahin.viewmodel.AuthViewModel
import cz.levinzonr.saferoute.core.annotations.Route
import kotlinx.coroutines.launch

@Route("account")
@Composable
fun AccountScreen(navController: NavController, vm: AuthViewModel = hiltViewModel()) {
    val state = vm.state.value
    val scope = rememberCoroutineScope()

    fun onSignOutPressed() {
        scope.launch {
            vm.onEvent(AuthEvent.SignOut)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ProfileCard(
            name = state.user?.displayName,
            email = state.user?.email,
        )
        ItemDivider(0.dp)
        Navigation.SETTINGS.forEach { setting ->
            ListItem(
                icon = setting.icon,
                title = setting.label,
                onClick = {
                    if (setting.route.isNotEmpty()) {
                        navController.navigate(setting.route)
                    }
                }
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Logout",
            style = Typography.button,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = ::onSignOutPressed),
        )
    }
}

@Preview
@Composable
fun AccountScreenPreview() {
    BuahinTheme {
        Scaffold {
            AccountScreen(rememberNavController())
        }
    }
}