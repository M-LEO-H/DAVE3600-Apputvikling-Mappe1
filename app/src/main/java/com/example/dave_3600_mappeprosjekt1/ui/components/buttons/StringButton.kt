package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


/**
 * Composable funksjon som brukes til å lage knapp. Den viser en string verdi og kaller en funksjon når den trykkes på.
 * Den skal bruke til å lage siffer knappene i tastaturet.
 *
 * @param string Teksten knappen skal vise
 * @param onClick Funksjon som kalles ved knapptrykk og tar med string verdien til knappen som trykkes.
 */
@Composable
fun StringButton(string: String, onClick: (String) -> Unit, modifier : Modifier = Modifier) {
    //Ved klikk kalles funksjonen onClick med string verdien som trykkes.
    Button(onClick = { onClick(string) },
        modifier = modifier,
        //Gir knappen farge.
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        )
    ) {
        Text(string)
    }

}


@Preview
@Composable
fun StringButtonPreview() {
    StringButton("X", onClick = {})

}