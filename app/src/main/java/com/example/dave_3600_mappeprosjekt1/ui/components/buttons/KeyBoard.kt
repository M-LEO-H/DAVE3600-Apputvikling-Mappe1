package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    onDigitClick: (String) -> Unit,
    onDeleteClick: () -> Unit,
    onSubmitClick: () -> Unit,
    ) {


    //val userInput = arrayOf()

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {

            Row {
                StringButton("1", onClick = onDigitClick, modifier = Modifier.weight(1f))
                StringButton("2", onClick = onDigitClick, modifier = Modifier.weight(1f))
                StringButton("3", onClick = onDigitClick, modifier = Modifier.weight(1f))

            }
            Row {
                StringButton("4", onClick = onDigitClick, modifier = Modifier.weight(1f))
                StringButton("5", onClick = onDigitClick, modifier = Modifier.weight(1f))
                StringButton("6", onClick = onDigitClick, modifier = Modifier.weight(1f))

            }
            Row {
                StringButton("7", onClick = onDigitClick, modifier = Modifier.weight(1f))
                StringButton("8", onClick = onDigitClick, modifier = Modifier.weight(1f))
                StringButton("9", onClick = onDigitClick, modifier = Modifier.weight(1f))

            }
            Row {
                StringButton("0", onClick = onDigitClick, modifier = Modifier.weight(1f))
                DeleteButton(onDeleteClick = onDeleteClick, modifier = Modifier.weight(1f))
                SubmitButton(onSubmitClick = onSubmitClick, modifier = Modifier.weight(1f))

            }

        }
    }




/*
@Preview(showBackground = true)
@Composable
fun KeyboardPreview() {
    Keyboard()
}*/
