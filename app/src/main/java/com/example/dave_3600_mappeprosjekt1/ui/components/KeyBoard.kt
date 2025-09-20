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

    ) {


    //val userInput = arrayOf()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter

    ) {
        Column {

            Row {
                StringButton("1", onClick = {it})
                StringButton("2", onClick = {it})
                StringButton("3", onClick = {it})

            }
            Row {
                StringButton("4", onClick = {it})
                StringButton("5", onClick = {it})
                StringButton("6", onClick = {it})

            }
            Row {
                StringButton("7", onClick = {it})
                StringButton("8", onClick = {it})
                StringButton("9", onClick = {it})

            }
            Row {
                StringButton("0", onClick = {it})

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
    Keyboard()
}