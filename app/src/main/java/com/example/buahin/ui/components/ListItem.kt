package com.example.buahin.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buahin.R
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Dark

@Composable
fun ListItem(icon: Int, title: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "")
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Dark,
            modifier = Modifier.weight(1f, true),
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "",
            tint = Dark,
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