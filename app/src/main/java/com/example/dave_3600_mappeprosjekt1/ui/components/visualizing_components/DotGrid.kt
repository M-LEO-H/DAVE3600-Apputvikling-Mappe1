package com.example.dave_3600_mappeprosjekt1.ui.components.visualizing_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DotGrid(
    count: Int,
    color: Color,
    dotsPerRow: Int = 5, // max per row before wrapping
    size: Dp = 32.dp
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val fullRows = count / dotsPerRow
        val remainder = count % dotsPerRow

        repeat(fullRows) {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                repeat(dotsPerRow) {
                    ShapeDot(color = color, size = size)
                }
            }
        }

        if (remainder > 0) {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                repeat(remainder) {
                    ShapeDot(color = color, size = size)
                }
            }
        }
    }
}
