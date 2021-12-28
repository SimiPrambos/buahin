/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * SearchBox.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.buahin.R
import com.example.buahin.ui.theme.*

@Composable
fun SearchBox(modifier: Modifier = Modifier) {
    val queryState = remember {
        mutableStateOf(TextFieldValue())
    }

    TextField(
        value = queryState.value,
        onValueChange = { queryState.value = it },
        shape = Shapes.medium,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Grey200,
            textColor = Dark,
            leadingIconColor = Dark,
            placeholderColor = Grey500,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        modifier = modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "",
            )
        },
        placeholder = {
            Text(text = "Search something...")
        }
    )
}

@Preview
@Composable
fun SearchBoxPreview() {
    BuahinTheme {
        SearchBox()
    }
}