package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buahin.R
import com.example.buahin.navigation.popToMain
import com.example.buahin.ui.components.LoadingAnimation
import com.example.buahin.ui.components.RoundedButton
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Typography
import com.example.buahin.viewmodel.OrderEvent
import com.example.buahin.viewmodel.OrderState
import com.example.buahin.viewmodel.OrderViewModel
import cz.levinzonr.saferoute.core.annotations.Route

@Route("order")
@Composable
fun OrderScreen(navController: NavController, vm: OrderViewModel = hiltViewModel()) {
    val status = when (vm.state.value) {
        is OrderState.Loading -> {
            OrderScreenStatus.Loading
        }
        is OrderState.Success -> {
            OrderScreenStatus.Success
        }
        else -> {
            OrderScreenStatus.Failed
        }
    }

    LaunchedEffect(true) {
        vm.onEvent(OrderEvent.Requested)
    }

    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 25.dp, vertical = 50.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(25.dp)
                    .weight(1f, true),
            ) {
                LoadingAnimation(
                    animationId = status.animationId,
                    modifier = Modifier.size(250.dp),
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = status.title,
                    style = Typography.h4.copy(textAlign = TextAlign.Center)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = status.subtitle,
                    style = Typography.subtitle1.copy(
                        textAlign = TextAlign.Center,
                        lineHeight = 21.sp,
                    )
                )
            }
            if (!status.actionLabel.isNullOrEmpty()) {
                RoundedButton.Filled(status.actionLabel) {
                    navController.popBackStack()
                    navController.navigateToOrders()
                }
                RoundedButton.Text("Back to Shop") {
                    navController.popToMain()
                }
            }
        }
    }
}

@Preview
@Composable
fun OrderScreenPreview() {
    BuahinTheme {
        OrderScreen(rememberNavController())
    }
}

sealed class OrderScreenStatus(
    val animationId: Int,
    val title: String,
    val subtitle: String,
    val actionLabel: String? = null,
) {
    object Loading : OrderScreenStatus(
        animationId = R.raw.order_loading,
        title = "Processing your order",
        subtitle = "Please wait while your order is being processed",
    )

    object Success : OrderScreenStatus(
        animationId = R.raw.order_success,
        title = "Your Order has been accepted",
        subtitle = "Your items has been placed and is on it’s way to being processed",
        actionLabel = "Track Order"
    )

    object Failed : OrderScreenStatus(
        animationId = R.raw.order_failed,
        title = "Oops! Order Failed",
        subtitle = "Something went wrong.",
        actionLabel = "Please Try Again"
    )
}