package com.example.dave_3600_mappeprosjekt1.ui.components.visualizing_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ShapeDot(color: Color, size: Dp = 32.dp) {
    Box(
        modifier = Modifier
            .size(size)
            .background(color, shape = CircleShape)
    )
}