package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.GameViewModel
import com.example.dave_3600_mappeprosjekt1.ui.components.nav.TopBar
import com.example.dave_3600_mappeprosjekt1.ui.components.buttons.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.theme.AppTheme


@Composable
fun PreferencePage(
    navController: NavController,
    gameViewModel: GameViewModel
) {
    val lengths = integerArrayResource(id = R.array.game_lengths).toList()
    val uiState by gameViewModel.uiState.collectAsState()


    //TODO: Fix how selected button looks, mby invert colour + increase text size if selected
    Scaffold(
        topBar = {
            TopBar(
                stringResource(id = R.string.preference),
                onBackClick = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
            OptionsScreen(
                modifier = Modifier.padding(innerPadding),
                options = lengths,
                onOptionClick = { length ->
                    gameViewModel.updateGameLength(length)
                },
                optionLabel = { length ->
                    val isSelected = uiState.gameLength == length
                    if (isSelected) "✅ $length" else length.toString()
                }
            )
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

    AppTheme {
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
