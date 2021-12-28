/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * RoundedButton.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Dark
import com.example.buahin.ui.theme.Primary
import com.example.buahin.ui.theme.Shapes

object RoundedButton {
    @Composable
    fun Filled(
        label: String,
        badge: String? = null,
        modifier: Modifier = Modifier,
        onClick: () -> Unit,
    ) {
        Button(
            onClick = onClick,
            modifier = modifier.fillMaxWidth(),
            shape = Shapes.large,
            contentPadding = PaddingValues(vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Primary,
                contentColor = Color.White,
            ),
            elevation = ButtonDefaults.elevation(0.dp),
        ) {
            Text(text = label)
            if (!badge.isNullOrEmpty()) {
                Badge(
                    modifier = Modifier.padding(start = 16.dp)
                ) { Text(text = badge) }
            }
        }
    }

    @Composable
    fun Text(label: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier.fillMaxWidth(),
            shape = Shapes.large,
            contentPadding = PaddingValues(vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.White,
            ),
            elevation = ButtonDefaults.elevation(0.dp),
        ) {
            Text(text = label, color = Dark)
        }
    }
}

@Preview
@Composable
fun RoundedButtonFilledPreview() {
    BuahinTheme {
        RoundedButton.Filled(label = "Filled Button", badge = "Rp 120.000", onClick = {})
    }
}

@Preview
@Composable
fun RoundedButtonTextPreview() {
    BuahinTheme {
        Surface {
            RoundedButton.Text(label = "Filled Button", onClick = {})
        }
    }
}