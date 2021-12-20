package com.example.buahin.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Primary
import com.example.buahin.ui.theme.Shapes

object RoundedButton {
    @Composable
    fun Filled(label: String, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            shape = Shapes.large,
            contentPadding = PaddingValues(vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Primary,
                contentColor = Color.White,
            ),
            elevation = ButtonDefaults.elevation(0.dp),
        ) {
            Text(text = label)
        }
    }
}

@Preview
@Composable
fun RoundedButtonFilledPreview() {
    BuahinTheme {
        RoundedButton.Filled(label = "Filled Button", onClick = {})
    }
}