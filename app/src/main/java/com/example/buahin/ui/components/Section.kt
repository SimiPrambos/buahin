/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * Section.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Primary
import com.example.buahin.ui.theme.Typography
import com.example.buahin.util.noRippleClickable

@Composable
fun Section(
    title: String,
    showMore: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .noRippleClickable(onClick = onClick),
    ) {
        Text(
            text = title,
            style = Typography.h5,
            fontWeight = FontWeight.SemiBold,
        )
        if (showMore)
            Text(
                text = "See all",
                color = Primary,
                style = Typography.subtitle1,
                fontWeight = FontWeight.SemiBold,
            )
    }
}

@Preview
@Composable
fun SectionPreview() {
    BuahinTheme {
        Section("Exclusive Offer")
    }
}