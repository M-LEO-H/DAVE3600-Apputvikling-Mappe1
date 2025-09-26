package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun <T> OptionsScreen(
    modifier: Modifier = Modifier,
    options: List<T>,
    onOptionClick: (T) -> Unit,
    optionLabel: (T) -> String = { it.toString() } // function to get display string
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(options) { option ->
                Button(
                    onClick = { onOptionClick(option) },
                    modifier = Modifier.width(240.dp)
                ) {
                    Text(optionLabel(option))
                }
            }
        }
    }
}


