package com.example.buahin.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Dark,
    ),
    h3 = TextStyle(
        fontSize = 48.sp,
        color = Color.White,
    ),
    h4 = TextStyle(
        fontSize = 26.sp,
        color = Dark,
        lineHeight = 29.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        letterSpacing = 0.sp,
        color = Dark,
    ),
    subtitle1 = TextStyle(
        color = Grey500,
        fontWeight = FontWeight.Medium,
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)