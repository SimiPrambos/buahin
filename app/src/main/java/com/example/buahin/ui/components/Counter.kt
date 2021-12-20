package com.example.buahin.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.R
import com.example.buahin.ui.theme.*

@Composable
fun Counter(value: Int = 1, onDecreased: () -> Unit, onIncreased: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedButton(
            onClick = { onDecreased() },
            shape = Shapes.large,
            modifier = Modifier.size(45.dp),
            enabled = value > 1,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = "",
            )
        }
        Text(
            text = value.toString(),
            style = Typography.subtitle1,
            fontWeight = FontWeight.SemiBold,
            color = Dark,
            modifier = Modifier.padding(horizontal = 15.dp),
        )
        OutlinedButton(
            onClick = { onIncreased() },
            shape = Shapes.large,
            modifier = Modifier.size(45.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_plus), contentDescription = "")
        }
    }
}

@Preview
@Composable
fun CounterPreview() {
    BuahinTheme {
        Counter(onDecreased = {}, onIncreased = {})
    }
}