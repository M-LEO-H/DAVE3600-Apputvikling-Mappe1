package com.example.dave_3600_mappeprosjekt1.ui.components


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Feedback(result : Boolean) {
        if (result) {
            CorrectAnswer()
        } else {
            wrongAnswer()
        }

    }
@Composable
fun AlertDialogStock(
    nextQuestion : () -> Unit,
    retry : () -> Unit,
    alertText : String,
    alertTitle : String,
    isCorrect : Boolean
) {
    AlertDialog(
        text = {
            Text(alertText)
        },
        title = {
            Text(alertTitle)
        },
        confirmButton = {
            Button(onClick = {
                nextQuestion()
            },
                enabled = isCorrect
            ) {
                Text("Next question")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                retry()
            },
                enabled = !isCorrect
            ) {
                Text("Retry")
            }
        },
        onDismissRequest = {
            retry()
        }

    )

}

@Composable
fun CorrectAnswer() {

}

fun wrongAnswer() {
    TODO("Not yet implemented")
}


@Preview
@Composable
fun AlertDialogPreview() {
    AlertDialogStock(
        {},
        {},
        "Du har korrekt",
        "Resultat",
        isCorrect = true)
}