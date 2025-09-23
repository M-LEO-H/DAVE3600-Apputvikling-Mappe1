package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.GameViewModel
import com.example.dave_3600_mappeprosjekt1.ui.components.RadioButtonListHorizontal
import com.example.dave_3600_mappeprosjekt1.ui.components.TopBar
import com.example.dave_3600_mappeprosjekt1.ui.components.UnderTitle
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme


@Composable
fun PreferencePage(
    gameViewModel: GameViewModel
){
    val lengths = integerArrayResource(id = R.array.game_lengths).toList()
    Scaffold(

        topBar = { TopBar(stringResource(id = R.string.preference))}
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            items(lengths) { length ->

                Button(
                    onClick = {gameViewModel.updateGameLength(length)
                    }
                ) {
                    Text(length.toString())
                }

            }



        }
    }
}


/*
@Preview(name = "English")
@Preview(name = "Norsk", locale = "nb")
@Preview(name = "German", locale = "de")
@Composable
fun PreferencePagePreview() {
    DAVE3600Mappeprosjekt1Theme {
        PreferencePage()
    }
}*/

@Preview(name = "Preview with interactive state")
@Composable
fun PreferencePagePreviewInteractive() {
    // Fake gameLength state
    var gameLength by remember { mutableIntStateOf(10) }

    val lengths = listOf(5, 10, 15) // you can also use integerArrayResource if in a real app

    DAVE3600Mappeprosjekt1Theme {
        Scaffold(topBar = { TopBar("Preference") }) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Current Game Length: $gameLength")

                lengths.forEach { length ->
                    Button(onClick = { gameLength = length }, modifier = Modifier.padding(8.dp)) {
                        Text(length.toString())
                    }
                }
            }
        }
    }
}
