package com.example.buahin.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.buahin.ui.theme.*
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun OrderCard(
    date: String,
    title: String,
    subtitle: String,
    status: String,
    thumbnail: String? = null,
    qty: Int,
    subtotal: String,
    count: Int,
    total: String,
    modifier: Modifier = Modifier,
) {
    Card(
        border = BorderStroke(0.5.dp, Grey300),
        elevation = 0.dp,
        modifier = modifier,
        shape = Shapes.medium,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = date, style = Typography.subtitle1, color = Dark)
                Text(text = status.uppercase(), style = Typography.subtitle2, color = Primary)
            }
            Row(
                modifier = Modifier.padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (thumbnail == null) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .placeholder(true)
                    )
                } else {
                    Image(
                        painter = rememberImagePainter(thumbnail),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.Center,
                        modifier = Modifier.size(80.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column() {
                    Row() {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = title,
                                style = Typography.subtitle1,
                                fontWeight = FontWeight.Bold,
                                color = Dark,
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = subtitle,
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
                        Text(
                            text = "x$qty",
                            style = Typography.subtitle1,
                        )
                        Text(
                            text = subtotal,
                            style = Typography.subtitle1,
                        )
                    }
                }
            }
            if (count > 1) {
                ItemDivider(0.dp)
                Text(
                    text = "Show more",
                    style = Typography.subtitle2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                )
            }
            ItemDivider(0.dp)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            ) {
                Text(text = "$count Product", style = Typography.subtitle1, color = Dark)
                Row {
                    Text(text = "Total Order : ", style = Typography.subtitle1, color = Dark)
                    Text(
                        text = total,
                        style = Typography.subtitle1,
                        color = Primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun OrderCardPreview() {
    BuahinTheme {
        Surface {
            OrderCard(
                date = "28-12-2021 22:30",
                status = "Completed",
                title = "Product title placeholder",
                subtitle = "325ml, Price",
                qty = 2,
                subtotal = "Rp xxx.xxx",
                count = 5,
                total = "Rp xxx.xxx"
            )
        }
    }
}