/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * CategoryCard.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.buahin.ui.theme.*
import com.example.buahin.util.noRippleClickable
import com.google.accompanist.placeholder.material.placeholder

object CategoryCard {
    @Composable
    fun Horizontal(title: String? = null, thumbnail: String? = null, onClick: () -> Unit = {}) {
        Card(
            shape = Shapes.large,
            elevation = 0.dp,
            border = BorderStroke(0.5.dp, Grey300),
            modifier = Modifier.noRippleClickable(onClick = onClick)
        ) {
            Row(
                modifier = Modifier.size(245.dp, 100.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (thumbnail.isNullOrEmpty())
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .placeholder(true)
                    )
                else
                    Image(
                        painter = rememberImagePainter(thumbnail),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp),
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
    fun Vertical(title: String? = null, thumbnail: String? = null, onClick: () -> Unit = {}) {
        Card(
            shape = Shapes.large,
            elevation = 0.dp,
            border = BorderStroke(0.5.dp, Grey300),
            modifier = Modifier
                .width(170.dp)
                .noRippleClickable(onClick = onClick),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
            ) {
                if (thumbnail.isNullOrEmpty())
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .placeholder(true)
                    )
                else
                    Image(
                        painter = rememberImagePainter(thumbnail),
                        contentDescription = "",
                        modifier = Modifier
                            .height(100.dp)
                            .padding(15.dp)
                            .fillMaxWidth(),
                    )
                Text(
                    text = title ?: "Buah & Sayur",
                    style = Typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = Dark,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.placeholder(title.isNullOrEmpty())
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
