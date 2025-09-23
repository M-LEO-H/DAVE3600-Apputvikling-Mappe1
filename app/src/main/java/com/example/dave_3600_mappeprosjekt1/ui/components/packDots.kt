package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.ui.graphics.Color
import com.example.dave_3600_mappeprosjekt1.ui.data.DotGroup

fun packDots(groups: List<DotGroup>, rowSize: Int): List<List<Color>> {
    val rows = mutableListOf<MutableList<Color>>()
    var currentRow = mutableListOf<Color>()

    for (group in groups) {
        var remaining = group.count
        while (remaining > 0) {
            val space = rowSize - currentRow.size
            val toAdd = minOf(space, remaining)

            repeat(toAdd) { currentRow.add(group.color) }
            remaining -= toAdd

            if (currentRow.size == rowSize) {
                rows.add(currentRow)
                currentRow = mutableListOf()
            }
        }
    }

    if (currentRow.isNotEmpty()) {
        rows.add(currentRow)
    }

    return rows
}