package com.example.dave_3600_mappeprosjekt1.ui.components.visualizing_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * En rad med sirkler som visualiser tallene i en oppgave.
 *
 * Hver prikk representeres som en farget sirkel via [ShapeDot].
 * Antallet prikker i raden bestemmes av lengden på [colors]-listen,
 * og fargene bestemmes av elementene i listen.
 *
 * @param colors Liste med farger for hver prikk som skal vises.
 * @param size Størrelsen på hver prikk (default = 32.dp).
 * @param spacing Avstanden mellom prikkene (default = 4.dp)
 */
@Composable
fun DotRow(colors: List<Color>, size: Dp = 32.dp, spacing: Dp = 4.dp)
{
    //Rad som legger prikkene inn i.
    Row(horizontalArrangement = Arrangement.spacedBy(spacing)) {
        colors.forEach { color ->
            //Tegner sirkel
            ShapeDot(color = color, size = size)
        }
    }
}