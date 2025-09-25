package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DeleteButton(
    onDeleteClick:() -> Unit
){
    Button(onClick = { onDeleteClick() }) {
        Text("Delete")

    }
}