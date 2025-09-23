package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DotRowsWithNumbers(packedRows: List<List<Pair<Color, Int>>>) {
    packedRows.forEach { row ->
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            row.forEach { (color, number) ->
                NumberedDot(color, number)
            }
        }
    }
}