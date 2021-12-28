/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * TopBar.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Typography
import com.example.buahin.R

typealias TopBarBackHandler = () -> Unit

@Composable
fun TopBar(
    title: String? = null,
    elevation: Dp = 3.dp,
    onBackPressed: TopBarBackHandler? = null,
    trailing: @Composable() (() -> Unit)? = null,
    backIcon: Int = R.drawable.ic_arrow_left,
    backgroundColor: Color = Color.White,
    modifier: Modifier = Modifier,
) {
    TopAppBar(backgroundColor = backgroundColor, elevation = elevation, modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(48.dp)) {
                if (onBackPressed != null) {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            painter = painterResource(id = backIcon),
                            contentDescription = "",
                        )
                    }
                }
            }
            Box(modifier = Modifier.weight(1f, true)) {
                if (title != null) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        style = Typography.h6,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
            Box(modifier = Modifier.size(48.dp)) {
                trailing?.invoke()
            }
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    BuahinTheme {
        Scaffold(topBar = { TopBar(title = "Title", onBackPressed = {}) }) {

        }
    }
}