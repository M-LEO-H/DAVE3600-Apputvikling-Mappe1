package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SubmitButton(
    onSubmitClick:() -> Unit
){
    Button(onClick = { onSubmitClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onTertiary
        )
        ) {
        Text("Submit")

    }
}

