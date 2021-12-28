package com.example.buahin.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buahin.R
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Dark
import com.example.buahin.ui.theme.Grey500
import com.example.buahin.ui.theme.Typography
import com.example.buahin.util.noRippleClickable

@Composable
fun ExpandableListTile(title: String, description: String, expand: Boolean = false) {
    val expanded = remember {
        mutableStateOf(expand)
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        ItemDivider(0.dp)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .noRippleClickable {
                    expanded.value = !expanded.value
                },
        ) {
            Text(
                text = title,
                style = Typography.subtitle1,
                fontWeight = FontWeight.SemiBold,
                color = Dark,
            )
            Icon(
                painter = painterResource(
                    if (expanded.value) R.drawable.ic_arrow_down else R.drawable.ic_arrow_right
                ),
                contentDescription = "",
                modifier = Modifier.size(14.dp),
            )
        }
        AnimatedVisibility(visible = expanded.value) {
            Text(
                text = description,
                style = Typography.caption,
                fontSize = 13.sp,
                lineHeight = 21.sp,
                color = Grey500,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}