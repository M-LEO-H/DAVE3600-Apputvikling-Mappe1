package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Composable funksjon for å lage og vise et tastatur som skal brukes til user input i spillet.
 * Den er bygget opp av flere "Stringbutton", en "Deletebutton", og en "Submitbutton".
 * Hver Stringbutton inneholder en string verdi som skal vises, og brukes for sifferene 0-9.
 * Hver knapp har en egen onClick funksjon som brukes når knappen trykkes.
 */

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    onDigitClick: (String) -> Unit,
    onDeleteClick: () -> Unit,
    onSubmitClick: () -> Unit,
    ) {


        //Kolonne som skal inneholde alle knappene og brukes til å holde orden på plasseringen til knappene.
        Column(
            modifier = modifier,
            //Skaper mellomrom mellom knappene.
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            //Rader med knappene. Inneholder sifferene 0-9, submit knapp, og en delete knapp

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
