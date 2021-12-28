/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * ProductCard.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.buahin.R
import com.example.buahin.ui.theme.*
import com.example.buahin.util.noRippleClickable
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun ProductCard(
    title: String? = null,
    subtitle: String? = null,
    price: String? = null,
    thumbnail: String? = null,
    onClick: () -> Unit = {}
) {
    val painter: Painter =
        if (thumbnail == null) painterResource(id = R.drawable.apple) else rememberImagePainter(
            thumbnail
        )
    Card(
        shape = Shapes.large,
        modifier = Modifier
            .size(170.dp, 225.dp)
            .noRippleClickable(onClick = onClick),
        border = BorderStroke(0.5.dp, Grey300),
        elevation = 0.dp,
    ) {
        Column {
            if (thumbnail.isNullOrEmpty()) {
                Box(
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .placeholder(thumbnail == null)
                )
            } else {
                Image(
                    painter = painter,
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth(),
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = title ?: "This is title",
                style = Typography.subtitle1,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Dark,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .placeholder(title.isNullOrEmpty()),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = subtitle ?: "subtitle",
                style = Typography.subtitle2,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Grey500,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .placeholder(subtitle.isNullOrEmpty()),
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = price ?: "Rp. 123456",
                style = Typography.subtitle1,
                lineHeight = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Dark,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .placeholder(price.isNullOrEmpty()),
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