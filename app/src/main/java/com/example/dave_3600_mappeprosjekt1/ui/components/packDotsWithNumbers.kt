package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.ui.graphics.Color
import com.example.dave_3600_mappeprosjekt1.ui.data.DotGroup

fun packDotsWithNumbers(groups: List<DotGroup>, rowSize: Int): List<List<Pair<Color, Int>>> {
    val allDots = mutableListOf<Pair<Color, Int>>()
    var counter = 1

    for (group in groups) {
        repeat(group.count) {
            allDots.add(Pair(group.color, counter))
            counter++
        }
    }

    val totalRows = (allDots.size + rowSize - 1) / rowSize
    val rows = MutableList(totalRows) { mutableListOf<Pair<Color, Int>>() }

    // Start filling from the bottom row
    var currentRow = totalRows - 1
    var index = 0

    while (index < allDots.size) {
        rows[currentRow].add(allDots[index])
        index++

        if (rows[currentRow].size == rowSize) {
            currentRow = (currentRow - 1).coerceAtLeast(0) // never go below 0
        }
    }

    return rows
}
