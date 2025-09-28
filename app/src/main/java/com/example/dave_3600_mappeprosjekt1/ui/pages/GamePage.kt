package com.example.dave_3600_mappeprosjekt1.ui.pages

import com.example.dave_3600_mappeprosjekt1.ui.components.dialogs.DialogAlert
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.GameViewModel
import com.example.dave_3600_mappeprosjekt1.ui.components.buttons.Keyboard
import com.example.dave_3600_mappeprosjekt1.ui.components.nav.TopBar
import com.example.dave_3600_mappeprosjekt1.ui.data.ShowAddition
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.dave_3600_mappeprosjekt1.ui.components.visualizing_components.AdditionVisualizer


/**
 * Side som viser spill skjermen for appen.
 * Viser:
 *  - Brukerens nåværende poeng.
 *  - Oppgaven som skal løses.
 *  - Inputfelt og numerisk tastatur for svar.
 *  - Dialoger ved feil svar, spill over eller når brukeren vil avslutte.
 *
 * @param navController Navigeringskontroller for navigasjon
 * @param gameViewModel Viewmodel for spill
 */

@Composable
fun GamePage(
    navController: NavHostController,
    gameViewModel: GameViewModel)
{
    val gameUiState by gameViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                stringResource(id = R.string.game),
                onBackClick = { gameViewModel.backClick() }
            )
        }
    ) { innerPadding ->
        gameUiState.currentAddition?.let {
            BoxWithConstraints(modifier = Modifier.padding(innerPadding).fillMaxSize())
            {
                //Velger hvilken layout som skal brukes basert på skjermens størrelse
                if (maxWidth > maxHeight){
                    HorizontalGameLayout(
                        userScore = gameUiState.score,
                        currentAddition = gameViewModel.currentAddition,
                        userGuess = gameViewModel.userGuess,
                        onUserGuessChanged = { gameViewModel.updateUserGuess(it) },
                        isAnswerWrong = gameUiState.isAnswerWrong,
                        onDigitClick = { gameViewModel.addDigit(it) },
                        onDeleteClick = { gameViewModel.deleteLast() },
                        onSubmitClick = { gameViewModel.submitAnswer() },
                        modifier = Modifier.fillMaxSize()

                    )
                } else {
                    VerticalLayout(
                        userScore = gameUiState.score,
                        currentAddition = gameViewModel.currentAddition,
                        userGuess = gameViewModel.userGuess,
                        onUserGuessChanged = { gameViewModel.updateUserGuess(it) },
                        isAnswerWrong = gameUiState.isAnswerWrong,
                        onDigitClick = { gameViewModel.addDigit(it) },
                        onDeleteClick = { gameViewModel.deleteLast() },
                        onSubmitClick = { gameViewModel.submitAnswer() },
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }



            //Viser dialog ved feil svar
            if (gameUiState.isAnswerWrong) {
                DialogAlert(

                    dialogTitle = {
                        Text(
                            text = stringResource(R.string.wrong_answer),
                        )
                    },
                    dialogText = {
                        AdditionVisualizer(
                            gameUiState.currentAddition,
                            modifier = Modifier.padding(16.dp)
                        )
                    },
                    confirmButton = {
                        Button(onClick = { gameViewModel.tryAgain() }) {
                            Text(stringResource(R.string.try_again))
                        }
                    }
                )
            }
            //Viser dialog ved spillets slutt
            if (gameUiState.isGameOver) {
                DialogAlert(
                    dialogTitle =  {
                        Text(
                            text = stringResource(R.string.game_over),
                        )
                    },
                    dialogText = {
                        Text("${stringResource(R.string.final_score)}: ${gameUiState.score} / ${gameUiState.gameLength}")
                    },
                    confirmButton = {
                        Button(onClick = { gameViewModel.resetGame() }) {
                            Text(stringResource(R.string.play_again))
                        }
                    },
                    dismissButton = {
                        Button(onClick = { navController.navigateUp() }) {
                            Text(stringResource(R.string.home))
                        }
                    }
                )
            }

        }
        // Vis dialog når brukeren prøver å avslutte spillet
        if(gameUiState.quitDialog){
            DialogAlert(
                dialogTitle = {
                    Text(
                        text= stringResource(R.string.want_to_leave),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                },
                dialogText = {
                    Text(
                        text= stringResource(R.string.game_process_will_be_reset),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                },
                dismissButton = {
                    Button(onClick = { gameViewModel.dismissBackClick() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )


                    ) {
                        Text(
                            text = stringResource(R.string.stay),
                            textAlign = TextAlign.Center,

                        )
                    }
                },
                confirmButton = {
                    Button(onClick = {
                        gameViewModel.resetGame()
                        navController.navigateUp() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                            contentColor = MaterialTheme.colorScheme.onError
                        )



                    ) {
                        Text(stringResource(R.string.leave))
                    }
                }
            )
        }
    }
}


/**
 * Horisontal layout for spill-skjermen.
 *
 * Viser score, oppgave og inputfelt side ved side.
 *
 * @param userScore Nåværende poengsum.
 * @param currentAddition Oppgaven som skal løses.
 * @param userGuess Brukerens nåværende svar.
 * @param onUserGuessChanged Callback når bruker endrer input.
 * @param isAnswerWrong Angir om forrige svar var feil.
 * @param onDigitClick Callback når et siffer trykkes.
 * @param onDeleteClick Callback for sletting.
 * @param onSubmitClick Callback for innsending av svar.
 * @param modifier Modifier for layout.
 */
@Composable
fun HorizontalGameLayout(
    onDigitClick: (String) -> Unit,
    onDeleteClick: () -> Unit,
    onSubmitClick: () -> Unit,
    userScore: Int,
    currentAddition: ShowAddition,
    userGuess: String,
    onUserGuessChanged: (String) -> Unit,
    isAnswerWrong: Boolean,
    modifier: Modifier = Modifier
){

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(1.dp),
    ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Card {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize(0.75f)
                        ,
                    ) {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "${stringResource(R.string.score)}: $userScore",
                                fontSize = 20.sp
                            )

                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = " ${stringResource(R.string.solve_this)} : ",
                                fontSize = 20.sp
                            )

                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(5f),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "${currentAddition.a} + ${currentAddition.b}",
                                fontSize = 75.sp
                            )
                        }
                    }
                }



            }


        Column(modifier = Modifier
                .weight(1f)
                .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        )
        {
            Card{
                Column {
                    OutlinedTextField(
                        value = userGuess,
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = onUserGuessChanged,
                        label = { Text(stringResource(R.string.enter_your_answer)) },
                        isError = isAnswerWrong,

                    )

                    Keyboard(
                        onDigitClick = onDigitClick,
                        onDeleteClick = onDeleteClick,
                        onSubmitClick = onSubmitClick
                    )
                }
            }


        }
    }
}

/**
 * Vertikal layout for spill-skjermen.
 *
 * Viser score, oppgave og inputfelt under hverandre.
 *
 * Parametre: Samme som [HorizontalGameLayout].
 */
@Composable
fun VerticalLayout(
    onDigitClick: (String) -> Unit,
    onDeleteClick: () -> Unit,
    onSubmitClick: () -> Unit,
    userScore: Int,
    currentAddition: ShowAddition,
    userGuess: String,
    onUserGuessChanged: (String) -> Unit,
    isAnswerWrong: Boolean,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,



    ) {

        Card(

            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .padding(horizontal = 20.dp, vertical = 20.dp)


        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,


            ) {
                Text(
                    text = "${stringResource(R.string.score)}: $userScore",
                    fontSize = 20.sp

                    )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = stringResource(R.string.solve_this),
                    fontSize = 20.sp
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {


                    Text(
                        text = "${currentAddition.a} + ${currentAddition.b}",
                        fontSize = 75.sp
                    )
                }
            }

        }
        Spacer(modifier = Modifier.padding(20.dp))
        Card(

            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),

            ) {
                OutlinedTextField(
                    value = userGuess,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    onValueChange = onUserGuessChanged,
                    label = { Text(stringResource(R.string.enter_your_answer)) },
                    isError = isAnswerWrong,
                )

               // Spacer(modifier = Modifier.padding(12.dp))
                Keyboard(
                    onDigitClick = onDigitClick,
                    onDeleteClick = onDeleteClick,
                    onSubmitClick = onSubmitClick,
                    modifier = Modifier.weight(1f)


                    )


            }

        }

    }

}

