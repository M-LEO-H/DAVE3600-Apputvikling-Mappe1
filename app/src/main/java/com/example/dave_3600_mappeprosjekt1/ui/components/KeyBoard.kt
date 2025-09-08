package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    buttonClick: (String) -> Unit) {
    //val userInput = arrayOf()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter

    ) {
        Column {

            Row {
                Button(onClick = { buttonClick("1") }) { Text("1") }
                Button(onClick = { buttonClick("2") }) { Text("2") }
                Button(onClick = { buttonClick("3") }) { Text("3") }
            }
            Row {
                Button(onClick = { buttonClick("4") }) { Text("4") }
                Button(onClick = { buttonClick("5") }) { Text("5") }
                Button(onClick = { buttonClick("6") }) { Text("6") }
            }
            Row {
                Button(onClick = { buttonClick("7") }) { Text("7") }
                Button(onClick = { buttonClick("8") }) { Text("8") }
                Button(onClick = { buttonClick("9") }) { Text("9") }
            }
            Row {
                Button(onClick = { buttonClick("0") }) { Text("0") }
                Button(onClick = { buttonClick("DEL") }) { Text("DEL") }
                Button(onClick = { buttonClick("Angi svar") }) { Text("Angi svar") }
            }

        }
    }
}


@Composable
fun Display() {
    Text("")
}


@Preview(showBackground = true)
@Composable
fun KeyboardPreview() {
    Keyboard(buttonClick = {})
}