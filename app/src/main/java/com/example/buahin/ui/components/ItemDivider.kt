package com.example.buahin.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.theme.Grey300

@Composable
fun ItemDivider(horizontalPadding: Dp = 16.dp) {
    Divider(color = Grey300, modifier = Modifier.padding(horizontal = horizontalPadding))
}