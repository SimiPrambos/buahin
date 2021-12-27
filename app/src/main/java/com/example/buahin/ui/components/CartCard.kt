package com.example.buahin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import coil.compose.rememberImagePainter
import com.example.buahin.R
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Dark
import com.example.buahin.ui.theme.Grey500
import com.example.buahin.ui.theme.Typography
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun CartCard(
    title: String? = null,
    subtitle: String? = null,
    subtotal: String? = null,
    qty: Int? = null,
    thumbnail: String? = null,
    onIncrease: () -> Unit = {},
    onDecrease: () -> Unit = {},
    onRemove: () -> Unit = {},
) {
    Card(modifier = Modifier.fillMaxWidth(), elevation = 0.dp) {
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
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = title ?: "Product title placeholder",
                                style = Typography.subtitle1,
                                fontWeight = FontWeight.Bold,
                                color = Dark,
                                modifier = Modifier.placeholder(title.isNullOrEmpty())
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = "",
                                tint = Grey500,
                                modifier = Modifier
                                    .size(14.dp)
                                    .clickable(onClick = onRemove),
                            )

                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = subtitle ?: "325ml, Price",
                            style = Typography.subtitle2,
                            fontWeight = FontWeight.Medium,
                            color = Grey500,
                            modifier = Modifier.placeholder(subtitle.isNullOrEmpty())
                        )
                    }

                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    if (qty != null)
                        Counter(
                            value = qty,
                            onDecreased = onDecrease,
                            onIncreased = onIncrease,
                        )
                    Text(
                        text = subtotal ?: "Rp. xxx.xxx",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Dark,
                        modifier = Modifier.placeholder(subtotal.isNullOrEmpty())
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