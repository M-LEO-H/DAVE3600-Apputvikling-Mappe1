package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun StringButton(string: String, onClick: (String) -> Unit) {
    Button(onClick = { onClick(string) }) {
        Text(string)
    }

}