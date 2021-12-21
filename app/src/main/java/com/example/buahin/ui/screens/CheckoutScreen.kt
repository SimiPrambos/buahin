package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buahin.R
import com.example.buahin.ui.components.ItemDivider
import com.example.buahin.ui.components.ListItem
import com.example.buahin.ui.components.RoundedButton
import com.example.buahin.ui.theme.*

@Composable
fun CheckoutScreen(onCancelPressed: () -> Unit) {
    Card(shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp)) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Checkout",
                    style = Typography.h5,
                )
                IconButton(onClick = onCancelPressed) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = "",
                    )
                }
            }
            ItemDivider()
            ListItem(
                title = "Delivery",
                titleStyle = Typography.button.copy(color = Grey500),
                preTrailing = {
                    Text(
                        text = "Select Method",
                        style = Typography.subtitle1.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Dark,
                        ),
                    )
                },
                onClick = {}
            )
            ListItem(
                title = "Payment",
                titleStyle = Typography.button.copy(color = Grey500),
                onClick = {}
            )
            ListItem(
                title = "Promo Code",
                titleStyle = Typography.button.copy(color = Grey500),
                preTrailing = {
                    Text(
                        text = "Pick Discount",
                        style = Typography.subtitle1.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Dark,
                        ),
                    )
                },
                onClick = {}
            )
            ListItem(
                title = "Total Cost",
                titleStyle = Typography.button.copy(color = Grey500),
                preTrailing = {
                    Text(
                        text = "Rp. 320.000",
                        style = Typography.subtitle1.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Dark,
                        ),
                    )
                },
                onClick = {}
            )
            Box(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "By placing an order you agree to our Terms And Conditions",
                    style = Typography.subtitle2.copy(
                        color = Grey500,
                        lineHeight = 21.sp,
                    ),
                )
            }
            RoundedButton.Filled(
                "Place Order",
                onClick = {},
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
            )
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}

@Preview
@Composable
fun CheckoutScreenPreview() {
    BuahinTheme {
        CheckoutScreen(onCancelPressed = {})
    }
}