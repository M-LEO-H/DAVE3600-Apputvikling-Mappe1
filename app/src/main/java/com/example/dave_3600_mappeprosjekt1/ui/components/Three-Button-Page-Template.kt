package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun OptionsScreen(
    modifier: Modifier = Modifier,
    options: List<String>,
) {
    Box(modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ) {
        LazyColumn(
                    modifier = modifier
                    .align(Alignment.Center)
        ) {
                items(options) { option ->
                    Button(onClick = {/*TODO*/},modifier.width(240.dp)) {Text(option)}

                }
            }

    }

}

@Preview
@Composable
fun OptionsScreenPreview() {
    OptionsScreen(options = listOf("Option 1", "Option 2", "Option 3"))
}


