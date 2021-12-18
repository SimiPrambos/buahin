package com.example.buahin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.buahin.R
import com.example.buahin.ui.theme.BuahinTheme

@Composable
fun Banner() {
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Preview
@Composable
fun BannerPreview() {
    BuahinTheme {
        Banner()
    }
}