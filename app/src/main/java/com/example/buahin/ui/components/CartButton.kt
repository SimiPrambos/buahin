/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * CartButton.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.R

@Composable
fun CartButton(count: Int = 0, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        contentPadding = PaddingValues(vertical = 20.dp),
    ) {
        BadgedBox(
            badge = {
                Badge { Text(text = count.toString())}
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = ""
            )
        }
    }
}

@Preview
@Composable
fun CartButtonPreview() {

}