package com.example.dave_3600_mappeprosjekt1.ui.components.visualizing_components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * En rad med sirkler som viser tallene i en oppgave.
 *
 * @param total Tall som skal vises.
 * @param color Fargen til hver prikk.
 * @param rowSize Antall prikker i hver rad.
 */
@Composable
fun DotRows(total: Int, color: Color, rowSize: Int) {
    val rows = mutableListOf<List<Color>>()
    var remaining = total

    // Del opp totalen i rader, hver med maks rowSize prikker
    while (remaining > 0) {
        val count = minOf(rowSize, remaining)
        rows.add(List(count) { color })
        remaining -= count
    }

    // Draw from top to bottom
    Column {
        rows.forEach { row -> DotRow(row) }
    }
}