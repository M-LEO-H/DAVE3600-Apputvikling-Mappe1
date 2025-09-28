package com.example.dave_3600_mappeprosjekt1.ui.components.visualizing_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.data.DotGroup
import com.example.dave_3600_mappeprosjekt1.ui.data.ShowAddition

/**
 * Gjenbrukbar elemement som visualiserer en addisjonsoppgave.
 *
 * Denne composablen tar inn en [ShowAddition] og viser summen steg for steg:
 * - Først vises den første delen av oppgaven (a) som blå prikker.
 * - Deretter vises den andre delen (b) som røde prikker.
 * - Til slutt vises summen som en samlet visning av begge grupper med prikker.
 *
 * Prikkene grupperes i rader basert på [rowSize], slik at det er lettere å lese
 * og telle. Innholdet kan scrolles vertikalt dersom det blir for stort for skjermen.
 *
 * @param addition Addisjonsoppgaven som skal visualiseres. Dersom den er `null`, vises ingenting.
 * @param modifier [Modifier] som brukes for å tilpasse layouten.
 * @param rowSize Antall sirkler per row, default = 5
 */


@Composable
fun AdditionVisualizer(
    addition: ShowAddition?,
    modifier: Modifier = Modifier,
    rowSize: Int = 5
) {
    if (addition == null) return

    //Konverterer strengene til int, retunererer 0 viss null
    val aInt = addition.a.toIntOrNull() ?: 0
    val bInt = addition.b.toIntOrNull() ?: 0

    //Oppretter to grupper, en med farge blå, andre med rød
    val dotGroups = listOf(
        DotGroup(aInt, Color.Blue),
        DotGroup(bInt, Color.Red)
    )
    //Deler opp prikkene i rader basert på [rowSize]
    val packedRows = packDots(dotGroups, rowSize)

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
            //Overskrift
            Text(stringResource(R.string.lets_vizualize))

            //Viser radene og viser tegn mellom radene.
            DotRows(aInt, Color.Blue, rowSize)
            Text(text = "+")
            DotRows(bInt, Color.Red, rowSize)
            Text(text = "=")

            // Viser samlet resultat rad for rad (snudd for at toppen skal være riktig)
            packedRows.reversed().forEach { row ->
                DotRow(row)
            }


        }
    }





//Previews
/*

@Preview("2+3")
@Composable
fun AdditionVisualizerPreview2plus3() {
    AdditionVisualizer(ShowAddition("2", "3", "5"))
}

@Preview("8+2")
@Composable
fun AdditionVisualizerPreview8plus2() {
    AdditionVisualizer(ShowAddition("8", "2", "10"))
}


@Preview("6+6")
@Composable
fun AdditionVisualizerPreview6plus6() {
    AdditionVisualizer(ShowAddition("6", "6", "10"))
}

@Preview("10+6")
@Composable
fun AdditionVisualizerPreview10plus6() {
    AdditionVisualizer(ShowAddition("10", "6", "10"))
}
@Preview("1+2")
@Composable
fun AdditionVisualizerPreview1plus2() {
    AdditionVisualizer(ShowAddition("1", "2", "10"))
}*/
