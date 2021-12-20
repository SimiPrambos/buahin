package com.example.buahin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buahin.R
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Dark
import com.example.buahin.ui.theme.Grey500
import com.example.buahin.ui.theme.Typography

@Composable
fun CartCard() {
    val (qty, setQty) = remember { mutableStateOf(1) }

    fun decreaseQty() {
        setQty(qty - 1)
    }

    fun increaseQty() {
        setQty(qty + 1)
    }

    Card(modifier = Modifier.fillMaxWidth(), elevation = 0.dp) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column() {
                Row() {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Sprite Can",
                                style = Typography.subtitle1,
                                fontWeight = FontWeight.Bold,
                                color = Dark,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = "",
                                tint = Grey500,
                                modifier = Modifier.size(14.dp),
                            )

                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "325ml, Price",
                            style = Typography.subtitle2,
                            fontWeight = FontWeight.Medium,
                            color = Grey500,
                        )
                    }

                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Counter(
                        value = qty,
                        onDecreased = { decreaseQty() },
                        onIncreased = { increaseQty() },
                    )
                    Text(
                        text = "Rp. 10.500",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Dark,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CartCardPreview() {
    BuahinTheme {
        CartCard()
    }
}