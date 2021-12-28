/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * ListItem.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buahin.R
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Dark
import com.example.buahin.ui.theme.Typography
import com.example.buahin.util.noRippleClickable

@Composable
fun ListItem(
    icon: Int? = null,
    title: String,
    onClick: () -> Unit,
    preTrailing: @Composable() (() -> Unit)? = null,
    titleStyle: TextStyle = Typography.button.copy(color = Dark),
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .noRippleClickable(onClick = onClick),
    ) {
        if (icon != null) {
            Icon(painter = painterResource(id = icon), contentDescription = "")
            Spacer(modifier = Modifier.width(20.dp))
        }
        Text(
            text = title,
            style = titleStyle,
            modifier = Modifier.weight(1f, true),

        )
        preTrailing?.invoke()
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "",
            tint = Dark,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Preview
@Composable
fun ListItemPreview() {
    BuahinTheme {
        Surface {
            ListItem(R.drawable.ic_orders, "Orders", onClick = {})
        }
    }
}