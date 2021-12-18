package com.example.buahin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.R
import com.example.buahin.ui.theme.Dark
import com.example.buahin.ui.theme.Grey200
import com.example.buahin.ui.theme.Typography

object CategoryCard {
    @Composable
    fun Horizontal(title: String) {
        Card(
            backgroundColor = Grey200,
            shape = RoundedCornerShape(18.dp),
            elevation = 0.dp,
        ) {
            Row(
                modifier = Modifier.size(245.dp, 100.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fruits),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(15.dp),
                )
                Text(
                    text = title,
                    style = Typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = Dark,
                )
            }
        }
    }

}

@Preview
@Composable
fun CategoryCardHorizontalPreview() {
    CategoryCard.Horizontal("Buah & Sayur")
}
