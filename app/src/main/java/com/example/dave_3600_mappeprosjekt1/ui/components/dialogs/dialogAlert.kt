package com.example.dave_3600_mappeprosjekt1.ui.components.dialogs

import androidx.compose.material3.AlertDialog

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Gjenbrukbar dialog boks som brukes til å gi bruker informasjon og gi dem valg på hva dem vil gjøre videre.
 * Den er bygget opp av en tittel, en tekst og to knapper.
 * Blir gitt farger som skiller seg ut.
 * @param dialogTitle Viser tittel på dialogboksen.
 * @param dialogText Viser tekst på dialogboksen.
 * @param confirmButton Knapp hvor bruker velger å forsette med noe. Den er valgfri.
 * @param dismissButton Knapp hvor bruker velger å avslutte noe. Den er valgfri.
 */

@Composable
fun DialogAlert(
    dialogTitle: @Composable () -> Unit,
    dialogText: @Composable () -> Unit,
    confirmButton: @Composable ( () -> Unit)? = null,
    dismissButton: @Composable ( () -> Unit)? = null
) {
    //Alertdialog som viser tittel, tekst og to knapper.
    AlertDialog(
        //valgt og ikke gi en onDismissRequest ettersom bruker oppgir ønsket handling ved hjelp av knapper.
        onDismissRequest = {},
        //Viser tittel på dialogboks
        title = {
            dialogTitle()
        },
        //Viser tekst i dialogboks
        text = {
            dialogText()
        },
        //Farger i dialogboksen.
        containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
        textContentColor = Color.Black,
        titleContentColor = Color.Black,

        confirmButton = confirmButton ?: {},
        dismissButton = dismissButton ?: {},
    )
}




