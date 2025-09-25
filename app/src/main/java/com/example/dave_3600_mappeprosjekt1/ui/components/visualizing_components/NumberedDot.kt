package com.example.dave_3600_mappeprosjekt1.ui.components.visualizing_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun NumberedDot(color: Color, number: Int, size: Dp = 32.dp) {
    Box(
        modifier = Modifier
            .size(size)
            .background(color, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(text = number.toString(), color = Color.White)
    }
}