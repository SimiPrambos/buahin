package com.example.buahin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buahin.R
import com.example.buahin.ui.components.RoundedButton
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Typography
import cz.levinzonr.saferoute.core.annotations.Route

sealed class OrderStatusValue(
    val image: Int,
    val title: String,
    val subtitle: String,
    val actionLabel: String
) {
    object Accepted : OrderStatusValue(
        R.drawable.illustration_accepted,
        "Your Order has been accepted",
        "Your items has been placed and is on it’s way to being processed",
        "Track Order"
    )

    object Failed : OrderStatusValue(
        R.drawable.illustration_failed,
        "Oops! Order Failed",
        "Something went wrong.",
        "Please Try Again"
    )
}

@Route("orderStatus")
@Composable
fun OrderStatusScreen(
    status: OrderStatusValue = OrderStatusValue.Accepted,
    onActionPressed: () -> Unit,
    onBackToHomePressed: () -> Unit,
) {
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
                Image(
                    painter = painterResource(status.image),
                    contentDescription = "",
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
            RoundedButton.Filled(status.actionLabel, onClick = onActionPressed)
            RoundedButton.Text("Back to Home", onClick = onBackToHomePressed)
        }
    }
}

@Preview
@Composable
fun OrderStatusScreenPreview() {
    BuahinTheme {
        OrderStatusScreen(onActionPressed = {}, onBackToHomePressed = {})
    }
}