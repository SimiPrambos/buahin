/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * BannerSlider.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.buahin.model.Banner
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Primary
import com.example.buahin.ui.theme.Shapes
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun BannerSlider(items: List<Banner>, modifier: Modifier = Modifier) {
    val state = rememberPagerState()

    Box(
        modifier = modifier
            .aspectRatio(16 / 6f)
            .padding(horizontal = 16.dp)
    ) {
        HorizontalPager(
            count = items.size,
            state = state,
        ) { page ->
            val thumbnail = items[page].thumbnail

            Image(
                painter = rememberImagePainter(thumbnail),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = modifier
                    .fillMaxSize()
                    .clip(Shapes.medium),
            )
        }
        HorizontalPagerIndicator(
            pagerState = state,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(vertical = 10.dp),
            activeColor = Primary
        )
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun BannerPreview() {
    BuahinTheme {
        BannerSlider(
            listOf(
                Banner("", "")
            )
        )
    }
}