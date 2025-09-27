package com.example.dave_3600_mappeprosjekt1.ui.components.visualizing_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dave_3600_mappeprosjekt1.ui.data.DotGroup
import com.example.dave_3600_mappeprosjekt1.ui.data.ShowAddition




@Composable
fun AdditionVisualizer(
    addition: ShowAddition?,
    modifier: Modifier = Modifier,
    rowSize: Int = 5
) {
    if (addition == null) return
    val aInt = addition.a.toIntOrNull() ?: 0
    val bInt = addition.b.toIntOrNull() ?: 0


    val dotGroups = listOf(
        DotGroup(aInt, Color.Blue),
        DotGroup(bInt, Color.Red)
    )
    val numberedRows = packDotsWithNumbers(dotGroups, rowSize)
    val packedRows = packDots(dotGroups, rowSize)

    val scrollState = rememberScrollState()

    Card(
        modifier = modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Let's visualize it:")

            DotRows(aInt, Color.Blue, rowSize)
            Text(text = "+")
            DotRows(bInt, Color.Red, rowSize)
            Text(text = "=")

            // Render rows from top to bottom
            packedRows.reversed().forEach { row ->
                DotRow(row)
            }

            // This is for answer
           /* Text(text = "LINEBREAK")
            numberedRows.forEach { row ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    row.forEach { (color, number) ->
                        NumberedDot(color = color, number = number)
                    }
                }
            }*/

        }
    }
}



@Preview("2+3")
@Composable
fun AdditionVisualizerPreview2plus3() {
    AdditionVisualizer(ShowAddition("2", "3", "5"))
}

@Preview("8+2")
@Composable
fun AdditionVisualizerPreview8plus2() {
    AdditionVisualizer(ShowAddition("8", "2", "10"))
}


@Preview("6+6")
@Composable
fun AdditionVisualizerPreview6plus6() {
    AdditionVisualizer(ShowAddition("6", "6", "10"))
}

@Preview("10+6")
@Composable
fun AdditionVisualizerPreview10plus6() {
    AdditionVisualizer(ShowAddition("10", "6", "10"))
}
@Preview("1+2")
@Composable
fun AdditionVisualizerPreview1plus2() {
    AdditionVisualizer(ShowAddition("1", "2", "10"))
}