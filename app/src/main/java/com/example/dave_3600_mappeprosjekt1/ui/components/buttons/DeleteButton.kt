package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dave_3600_mappeprosjekt1.ui.theme.AppTheme


/**
Composable knapp som skal fungere som en slett knapp. Den brukes til å fjerne et element.
Den er bygget av en knapp, som vil kalle funksjonen "onDeleteClick" når trykket.Det er dette som gjør at knappen sletter elementer.
Den blir gitt farge som skiller seg ut. Valgte å gi den "Error", selvom det ikke er en feil, ettersom den utfører en destruktiv hendelse.

@param onDeleteClick Kaller en funksjon når knappen bli trykket.

*/
@Composable
fun DeleteButton(
    onDeleteClick:() -> Unit,
    modifier : Modifier = Modifier
){
    //Knapp som kaller funksjonen "onDeleteClick" når trykket.
    Button(onClick = { onDeleteClick() },
        modifier = modifier,
        //Gitt farge som skiller seg ut. Gitt error farge grunnet destruktiv hendelse.
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError
        )) {
        Text("Delete")

    }
}

