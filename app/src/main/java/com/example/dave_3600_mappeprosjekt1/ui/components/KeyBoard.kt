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
    buttonClick: (Int) -> Unit) {
    //val userInput = arrayOf()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter

    ) {
        Column {

            Row {
                IntButton(1, onClick = buttonClick)
                IntButton(2, onClick = buttonClick)}
                IntButton(3, onClick = buttonClick)
            }
            Row {
                IntButton(4, onClick = buttonClick)
                IntButton(5, onClick = buttonClick)
                IntButton(6, onClick = buttonClick)

            }
            Row {
                IntButton(7, onClick = buttonClick)
                IntButton(8, onClick = buttonClick)
                IntButton(9, onClick = buttonClick)
            }
            Row {
                IntButton(0, onClick = buttonClick)
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