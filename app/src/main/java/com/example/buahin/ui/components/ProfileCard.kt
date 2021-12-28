/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * ProfileCard.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buahin.R
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Primary
import com.example.buahin.ui.theme.Typography

@Composable
fun ProfileCard(name: String? = null, email: String? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.apple),
            contentDescription = "",
            modifier = Modifier
                .size(65.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = name ?: "Simi Prambos",
                    style = Typography.h6,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 18.sp,
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_pencil),
                    contentDescription = "",
                    tint = Primary,
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = email ?: "simi.prambos@gmail.com",
                style = Typography.subtitle1,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    BuahinTheme {
        Surface() {
            ProfileCard()
        }
    }
}