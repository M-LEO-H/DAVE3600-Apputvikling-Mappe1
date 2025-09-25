package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StringButton(string: String, onClick: (String) -> Unit) {
    Button(onClick = { onClick(string) }) {
        Text(string)
    }

}


@Preview
@Composable
fun StringButtonPreview() {
    StringButton("X", onClick = {})

}