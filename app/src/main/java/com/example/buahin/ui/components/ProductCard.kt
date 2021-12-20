package com.example.buahin.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buahin.R
import com.example.buahin.ui.theme.*

@Composable
fun ProductCard(title: String, subtitle: String, price: String) {
    Card(
        shape = Shapes.large,
        modifier = Modifier.size(170.dp, 225.dp),
        border = BorderStroke(0.5.dp, Grey300),
        elevation = 0.dp,
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = title,
                modifier = Modifier.height(100.dp).fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = title,
                style = Typography.subtitle1,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Dark,
            )
            Text(
                text = subtitle,
                style = Typography.subtitle2,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Grey500,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = price,
                style = Typography.subtitle1,
                lineHeight = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Dark,
            )
        }
    }
}

@Preview
@Composable
fun ProductCardPreview() {
    BuahinTheme {
        ProductCard(
            "Read Apple",
            "1kg, Price",
            "Rp. 20.500",
        )
    }
}