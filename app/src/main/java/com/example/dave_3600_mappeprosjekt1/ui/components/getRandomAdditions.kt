package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme

data class ShowAddition(
    val a: Int,
    val b: Int,
    val answer: Int,
)



@Composable
fun getRandomAdditions(length: Int): List<ShowAddition> {
    val items = stringArrayResource(id = R.array.addition_array)
    return items.toList()
        .shuffled()
        .take(length)
        .map { str ->
            val parts = str.split(",")
            ShowAddition(
                a = parts[0].toInt(),
                b = parts[1].toInt(),
                answer = parts[2].toInt(),
            )
        }
}




@Preview(showBackground = true)
@Composable
fun ShowAdditionPreview() {
    DAVE3600Mappeprosjekt1Theme {
        getRandomAdditions(10)
    }
}