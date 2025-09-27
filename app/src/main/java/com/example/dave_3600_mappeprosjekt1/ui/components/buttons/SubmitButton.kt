package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SubmitButton(
    onSubmitClick:() -> Unit,
    modifier : Modifier = Modifier
){
    Button(onClick = { onSubmitClick() },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
        ) {
        Text("Submit")

    }
}

