package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme

@Composable
fun RadioButtonListHorizontal(listOptions: List<String>, modifier: Modifier = Modifier ) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(listOptions[0]) }

    Row(modifier.selectableGroup(), verticalAlignment = Alignment.CenterVertically) {
        listOptions.forEach { text ->
            Row(
                Modifier
                    .height(320.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {onOptionSelected(text)},
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
               RadioButton(
                   selected = (text == selectedOption),
                   onClick = null
               )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonPreview() {
    DAVE3600Mappeprosjekt1Theme {
        val list = listOf( "Norwegian", "German")
        RadioButtonListHorizontal(list)
    }
}