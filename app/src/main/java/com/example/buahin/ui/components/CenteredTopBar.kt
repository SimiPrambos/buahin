package com.example.buahin.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Typography

@Composable
fun CenteredTopBar(title: String) {
    TopAppBar(backgroundColor = Color.White, elevation = 1.dp) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = Typography.h6,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
fun CenteredTopBarPreview() {
    BuahinTheme {
        Scaffold(topBar = { CenteredTopBar("Title") }) {

        }
    }
}