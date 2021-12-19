package com.example.buahin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.R
import com.example.buahin.ui.theme.Dark
import com.example.buahin.ui.theme.Grey500
import com.example.buahin.ui.theme.Typography

@ExperimentalMaterialApi
@Composable
fun FavouriteCard() {
    Card(modifier = Modifier.fillMaxWidth(), elevation = 0.dp) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 30.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f, true)) {
                Text(
                    text = "Sprite Can",
                    style = Typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    color = Dark,
                )
                Text(
                    text = "325ml, Price",
                    style = Typography.subtitle2,
                    fontWeight = FontWeight.Medium,
                    color = Grey500,
                )
            }
            Text(
                text = "Rp. 10.500",
                style = Typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                color = Dark,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = "",
                tint = Dark,
            )
        }
//        ListItem(
//            icon = {
//            },
//            text = {
//                Text(
//                    text = "Sprite Can",
//                    style = Typography.subtitle1,
//                    fontWeight = FontWeight.Bold,
//                    color = Dark,
//                )
//            },
//            secondaryText = {
//                Text(
//                    text = "325ml, Price",
//                    style = Typography.subtitle2,
//                    fontWeight = FontWeight.Medium,
//                    color = Grey500,
//                )
//            },
//            trailing = {
//                Row(verticalAlignment = Alignment.Bottom) {
//                    Text(
//                        text = "Rp. 10.500",
//                        style = Typography.subtitle2,
//                        fontWeight = FontWeight.SemiBold,
//                        color = Dark,
//                    )
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_shop),
//                        contentDescription = ""
//                    )
//                }
//            }
//        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun FavouriteCardPreview() {
    BuahinTheme {
        FavouriteCard()
    }
}