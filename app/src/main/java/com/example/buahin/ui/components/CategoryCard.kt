package com.example.buahin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.R
import com.example.buahin.ui.theme.Dark
import com.example.buahin.ui.theme.Grey200
import com.example.buahin.ui.theme.Shapes
import com.example.buahin.ui.theme.Typography
import com.google.accompanist.placeholder.material.placeholder

object CategoryCard {
    @Composable
    fun Horizontal(title: String? = null) {
        Card(
            backgroundColor = Grey200,
            shape = Shapes.large,
            elevation = 0.dp,
        ) {
            Row(
                modifier = Modifier.size(245.dp, 100.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fruits),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(15.dp)
                        .placeholder(title.isNullOrEmpty()),
                )
                Text(
                    text = title ?: "Category",
                    style = Typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = Dark,
                    modifier = Modifier.placeholder(title.isNullOrEmpty())
                )
            }
        }
    }

    @Composable
    fun Vertical(title: String) {
        Card(
            backgroundColor = Grey200,
            shape = Shapes.large,
            elevation = 0.dp,
            modifier = Modifier.width(170.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fruits),
                    contentDescription = "",
                    modifier = Modifier
                        .height(100.dp)
                        .padding(15.dp)
                        .fillMaxWidth(),
                )
                Text(
                    text = title,
                    style = Typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = Dark,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview
@Composable
fun CategoryCardHorizontalPreview() {
    CategoryCard.Horizontal("Buah & Sayur")
}

@Preview
@Composable
fun CategoryCardVerticalPreview() {
    CategoryCard.Vertical("Buah & Sayur")
}
