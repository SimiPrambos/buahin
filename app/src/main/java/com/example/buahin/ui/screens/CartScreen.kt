package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.components.CartCard
import com.example.buahin.ui.components.TopBar
import com.example.buahin.ui.components.ItemDivider
import com.example.buahin.ui.components.RoundedButton
import com.example.buahin.ui.theme.BuahinTheme
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun CartScreen() {
    val bottomSheet = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    fun showCheckoutDialog() {
        coroutineScope.launch { bottomSheet.animateTo(ModalBottomSheetValue.Expanded) }
    }

    fun hideCheckoutDialog() {
        coroutineScope.launch { bottomSheet.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = bottomSheet,
        sheetContent = { CheckoutScreen(onCancelPressed = { hideCheckoutDialog() }) },
    ) {
        Scaffold(
            topBar = { TopBar(title = "My Cart") },
            floatingActionButton = {
                RoundedButton.Filled(
                    "Go to Checkout",
                    modifier = Modifier.padding(bottom = 60.dp, start = 16.dp, end = 16.dp),
                    onClick = { showCheckoutDialog() },
                )
            },
            floatingActionButtonPosition = FabPosition.Center,
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                repeat(10) {
                    CartCard()
                    ItemDivider(0.dp)
                }
                Spacer(modifier = Modifier.height(200.dp))
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun CartScreenPreview() {
    BuahinTheme {
        CartScreen()
    }
}
