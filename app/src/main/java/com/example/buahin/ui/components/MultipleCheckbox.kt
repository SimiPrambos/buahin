package com.example.buahin.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buahin.ui.theme.*

data class CheckboxValue(val label: String, var checked: Boolean = false)

@Composable
fun MultipleCheckbox(
    items: Map<String, CheckboxValue>,
    onItemCheckedChange: (String, CheckboxValue) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        items.forEach { item ->
            Row {
                Checkbox(
                    checked = item.value.checked,
                    onCheckedChange = {
                        onItemCheckedChange(item.key, item.value.copy(checked = it))
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary,
                        uncheckedColor = Grey300,
                    ),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = item.value.label, style = Typography.subtitle1, color = Dark)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
fun MultipleCheckboxPreview() {
    BuahinTheme {
        Surface() {
            MultipleCheckbox(
                mapOf(),
                onItemCheckedChange = { _, _ -> }
            )
        }
    }
}