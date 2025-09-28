package com.example.dave_3600_mappeprosjekt1.ui.components.visualizing_components

import androidx.compose.ui.graphics.Color
import com.example.dave_3600_mappeprosjekt1.ui.data.DotGroup

/**
 * Pakker prikker i rader basert på [rowSize].
 * Eks:
 * - Input: grupper = [ DotGroup(7, blå), DotGroup(4, rød) ], rowSize = 5
 * - Output: [
 *     [blå, blå, blå, blå, blå],
 *     [blå, blå, rød, rød, rød],
 *     [rød]
 *   ]
 * @param groups Lister med prikker og deres farger.
 * @param rowSize Antall prikker i hver rad.
 *
 * @return Lister med prikker i rader.
 */

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