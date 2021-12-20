package com.example.buahin.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.buahin.R

val Gilroy = FontFamily(
    Font(R.font.gilroy_regular, weight = FontWeight.Normal),
    Font(R.font.gilroy_medium, weight = FontWeight.Medium),
    Font(R.font.gilroy_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.gilroy_bold, weight = FontWeight.Bold),
    Font(R.font.gilroy_extra_bold, weight = FontWeight.ExtraBold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    Gilroy,
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
    h6 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp,
        color = Dark,
    ),
    subtitle1 = TextStyle(
        fontSize = 16.sp,
        color = Grey500,
        fontWeight = FontWeight.Medium,
    ),
    button = TextStyle(
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 18.sp,
    ),
    /* Other default text styles to override
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)