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


//A function that returns a list of random additions with no duplication.
@Composable
fun getRandomAdditions(length: Int): List<ShowAddition> {
    val items = stringArrayResource(id = R.array.addition_array)

    //Convert the string array to a list of ShowAddition objects, shuffels it, and takes in the
    //length set in preference
    return items.toList()
        .shuffled()
        .take(length) //TODO make this a parameter that is retrieved by the length set in preference
        .map { str ->
            val parts = str.split(",")
            //Convert the string parts to integers and return a ShowAddition object
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