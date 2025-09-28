package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dave_3600_mappeprosjekt1.R


/**
 * Gjenbrukbar composable som skal vise en liste med knapper.
 * Den er laget for å være generisk, og kan ta inn flere data typer.
 * Den bruker en lazycolumn for å effektivt vise lange lister.
 * Fargen på knappene endres basert på hva som blir satt inn. De er hardkodet ettersom skjermen endte opp med å kun bli brukt her.
 *
 *  @param modifier Modifier som brukes av boksen skjermen lages i.
 *  @param options Liste med det som skal vises
 *  @param onOptionClick Kaller en funksjon når knapper blir trykket.
 *  @param optionLabel Gir tekst i knappen.
 */

@Composable
fun <T> OptionsScreen(
    modifier: Modifier = Modifier,
    options: List<T>,
    onOptionClick: (T) -> Unit,
    optionLabel: (T) -> String = { it.toString() } // function to get display string
) {
    //Ytre boks for å sentrere innholdet.
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        //Lazycolumn for å dele opp listen i kolonner.
        LazyColumn(
            //Brukt for å sentrere innholdet mot midten.
            modifier = modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(options) { option ->
                Button(
                    onClick = { onOptionClick(option) },
                    //Gi knappene en fast bredde. Sørger for at knappene sin størrelse ikke er avhengig av input.
                    modifier = Modifier.width(240.dp),
                    //Gir farge basert på liste innhold. Er hardkodet ettersom listen er kun brukt en gang.
                    //Dersom play knapp skal fargen være primary.
                    colors = if(option == stringResource(R.string.game)){
                        ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary,
                        )
                    } else {
                        //Ikke Play knapper skal ha en annen farge.
                        ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.onSecondary,
                        )
                    }
                ) {
                    Text(optionLabel(option))
                }
            }
        }
    }
}


