package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.GameViewModel
import com.example.dave_3600_mappeprosjekt1.ui.components.Keyboard
import com.example.dave_3600_mappeprosjekt1.ui.components.TopBar
import com.example.dave_3600_mappeprosjekt1.ui.components.UnderTitle
import com.example.dave_3600_mappeprosjekt1.ui.components.getRandomAdditions
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dave_3600_mappeprosjekt1.ui.data.ShowAddition


@Composable
fun GamePage(
    navController: NavHostController,
    gameViewModel: GameViewModel = viewModel(),

) {
    Scaffold(
        topBar = { TopBar(stringResource(id = R.string.game),
            onBackClick = {navController.navigateUp()}) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GameLayout(
                onUserGuessChanged = {gameViewModel.updateGuess(it)},
                currentAddition = gameViewModel.currentAddition,
                userGuess = gameViewModel.userGuess,

            )
        }
    }
}

@Composable
fun GameLayout(
    modifier: Modifier = Modifier,
    onUserGuessChanged: (Int) -> Unit = {},
    currentAddition: ShowAddition,
    userGuess: Int,
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.game_text)
            )

        }

    }
    OutlinedTextField(
        value = userGuess,
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = {},
        label = { Text(stringResource(R.string.enter_your_word)) },
        isError = false
    )
}
fun checkAnswer
            (input: Int,
             correctAnswer: Int,
): Boolean {
    return if(input == correctAnswer){
        true
    }
    else false
}

@Composable
fun Display(input: String){
    Text(input)
}



@Preview(name = "English")
@Preview(name = "Norsk", locale = "nb")
@Preview(name = "German", locale = "de")
@Composable
fun GamePagePreview() {
    DAVE3600Mappeprosjekt1Theme {
        val navController = androidx.navigation.compose.rememberNavController()
        GamePage(navController)
    }
}