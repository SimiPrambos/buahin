/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * CartScreen.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buahin.R
import com.example.buahin.model.Product
import com.example.buahin.ui.components.*
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.viewmodel.CartEvent
import com.example.buahin.viewmodel.CartViewModel
import cz.levinzonr.saferoute.core.annotations.Route
import kotlinx.coroutines.launch

@Route("cart")
@ExperimentalMaterialApi
@Composable
fun CartScreen(navController: NavController, vm: CartViewModel = hiltViewModel()) {
    val bottomSheet = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    val state = vm.state.value

    fun onQtyChanged(index: Int, qty: Int) {
        var event: CartEvent = CartEvent.QtyChanged(index, qty)
        if (qty <= 0) {
            event = CartEvent.CartRemoved(index)
        }
        scope.launch { vm.onEvent(event) }
    }

    fun showCheckoutDialog() {
        scope.launch { bottomSheet.animateTo(ModalBottomSheetValue.Expanded) }
    }

    fun hideCheckoutDialog() {
        scope.launch { bottomSheet.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = bottomSheet,
        sheetShape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp),
        sheetContent = {
            CheckoutScreen(
                state.totalIdr,
                onCancelPressed = { hideCheckoutDialog() },
                onConfirmPressed = {
                    hideCheckoutDialog()
                    navController.popBackStack()
                    navController.navigateToOrder()
                }
            )
        },
    ) {
        Scaffold(
            topBar = { TopBar(title = "My Cart") },
            floatingActionButton = {
                if (state.items.isNotEmpty())
                    RoundedButton.Filled(
                        "Go to Checkout",
                        state.totalIdr,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        onClick = { showCheckoutDialog() },
                    )
            },
            floatingActionButtonPosition = FabPosition.Center,
        ) {
            if (state.items.isEmpty())
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    LoadingAnimation(R.raw.empty, modifier = Modifier.size(250.dp))
                }
            else
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxSize()
                ) {
                    items(state.items.size) {
                        val item = state.items[it]
                        CartCard(
                            title = item.product.name,
                            subtitle = item.product.summary,
                            thumbnail = item.product.thumbnail,
                            qty = item.qty,
                            subtotal = item.subtotalIdr(),
                            onIncrease = { onQtyChanged(it, item.qty + 1) },
                            onDecrease = { onQtyChanged(it, item.qty - 1) },
                            onRemove = { onQtyChanged(it, 0) },
                        )
                        ItemDivider(0.dp)
                    }
                }
        }
    }
}

@Composable
fun AddToCartWidget(
    count: Int = 0,
    onAddToCartPressed: () -> Unit,
    onShowCartPressed: () -> Unit,
) {
    Row(modifier = Modifier.padding(horizontal = 20.dp)) {
        RoundedButton.Filled(
            "Add to Cart",
            onClick = onAddToCartPressed,
            modifier = Modifier.weight(1f, true),
        )
        Spacer(modifier = Modifier.width(10.dp))
        CartButton(count, onClick = onShowCartPressed)
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun CartScreenPreview() {
    BuahinTheme {
        CartScreen(rememberNavController())
    }
}
