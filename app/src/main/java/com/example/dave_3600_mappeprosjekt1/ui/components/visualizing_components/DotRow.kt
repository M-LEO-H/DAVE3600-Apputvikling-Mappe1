package com.example.dave_3600_mappeprosjekt1.ui.components.visualizing_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DotRow(colors: List<Color>, size: Dp = 32.dp, spacing: Dp = 4.dp) {
    Row(horizontalArrangement = Arrangement.spacedBy(spacing)) {
        colors.forEach { color ->
            ShapeDot(color = color, size = size)
        }
    }
}