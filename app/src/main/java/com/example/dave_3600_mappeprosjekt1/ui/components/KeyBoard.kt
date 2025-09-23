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
    onDigitClick: (String) -> Unit,
    onDeleteClick: () -> Unit,
    onSubmitClick: () -> Unit,
    ) {


    //val userInput = arrayOf()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter

    ) {
        Column {

            Row {
                StringButton("1", onClick = onDigitClick)
                StringButton("2", onClick = onDigitClick)
                StringButton("3", onClick = onDigitClick)

            }
            Row {
                StringButton("4", onClick = onDigitClick)
                StringButton("5", onClick = onDigitClick)
                StringButton("6", onClick = onDigitClick)

            }
            Row {
                StringButton("7", onClick = onDigitClick)
                StringButton("8", onClick = onDigitClick)
                StringButton("9", onClick = onDigitClick)

            }
            Row {
                StringButton("0", onClick = onDigitClick)
                DeleteButton(onDeleteClick = onDeleteClick)
                SubmitButton (onSubmitClick = onSubmitClick)

            }

        }
    }
}




@Composable
fun Display() {
    Text("")
}


/*
@Preview(showBackground = true)
@Composable
fun KeyboardPreview() {
    Keyboard()
}*/
