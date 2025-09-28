package com.example.dave_3600_mappeprosjekt1.ui.components

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.data.GameUiState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.dave_3600_mappeprosjekt1.ui.data.ShowAddition
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.update

/**
 * Viewmodel for å håndtere spillogikk. Den sørger for at data ikke slettes når skjermen endres.
 * Viewmodelen har følgende oppaver :
 * - Henter tilfeldige oppgaver fra strings.xml og lager en liste med dem.
 * - Håndterer bruker input og sjekker om det er riktig. Dette inkluderer fjerning, innsetting og sjekking av tall.
 * - Sørger for at viktige beskjeder blir vist til bruker, f.eks feilmeldinger.
 * - Oppdaterer GameUiState med nye verdier basert på det som skjer i spillet. Dette kan føre til endring av innhold på skjermen.
 * - Tilbakestiller spiill dersom bruker går ut av spillet eller vil spille på ny.
 *
 */

class GameViewModel(application: Application) : AndroidViewModel(application) {
    //Lagrer brukerens svar som en String
    var userGuess by mutableStateOf("")
        private set
    //Stateflow som holder på GameUiState
    private var _uiState = MutableStateFlow(GameUiState())
    //Henter oppgaver fra strings.xml og lager en liste.
    private var allAdditions: Array<String> = application.resources.getStringArray(R.array.addition_array)
    //Listen med oppgaver som ble valgt for dette spillet.
    private lateinit var gameAdditions: MutableList<ShowAddition>
    //Stateflow som holder på GameUiState
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    //Spørsmålet bruker skal svare på akkurat nå
    lateinit var currentAddition: ShowAddition
    //Boolean verdi for å undersøke om det er første forsøk på en oppgave. Brukes til å bestemme om bruker skal få poeng eller ikke.
    private var firstGuess = true



    //Lager en liste med tilfeldige oppgaver. Velger antall basert på spill lengde.
    private fun getRandomAdditionsList() {

        gameAdditions = allAdditions
            .toList()
            //Lager tilfeldig rekkefølge
            .shuffled()
            .take(_uiState.value.gameLength)
            //Gjør om spørsmål til ShowAddition, som inneholder riktig svar, a og b.
            .map { str ->
                val parts = str.split(",")
                ShowAddition(
                    a = parts[0],
                    b = parts[1],
                    answer = parts[2]
                )
            }.toMutableList()
    }

    //Funksjon som henter og fjerneroppgave fra liste og retunerer den.
    //Hvis listen er tom så returnerer den null.
    private fun getNextAddition(): ShowAddition? {
        //Sjekker om det er mer spørsmål i spillrunde.
        if(gameAdditions.isEmpty()) {
            return null
        }
        //Henter og fjerner første spørsmål i listen.
        currentAddition = gameAdditions.removeAt(0)
        return currentAddition

    }

    //Funksjon som tilbakestiller spillet til default. Sørger for at man kan spillet om igjen.
    fun resetGame(){
        //Henter liste med oppgaver.
        getRandomAdditionsList()
        //Tilbakestiller bruker input
        userGuess = ""
        //Setter verdiene i GameUiState til default.
        _uiState.value = _uiState.value.copy(
            currentAddition = getNextAddition(),
            isAnswerWrong = false,
            isGameOver = false,
            score = 0,
            quitDialog = false
            )

    }



    //Legger til et tall til brukerens svar.
    fun addDigit(digit: String) {
        userGuess += digit
    }

    //Sletter siste tall i brukerens svar. Kan kun utføres dersom bruker har gitt noe input.
    fun deleteLast() {
       if(userGuess.isNotEmpty()){
           userGuess = userGuess.dropLast(1)
       }
    }

    //Funksjom som brukes når bruker vil sende inn svar. Har forskjell utfall basert på om bruker har riktig eller galt.
    fun submitAnswer(){
        //Sjekker om svaret er riktig eller galt
        if(checkAnswer(userGuess, currentAddition.answer)){
            //Riktig svar
            correctAnswer()
        } else {
            //Feil svar
            wrongAnswer()
        }
        //Tilbakestiller bruker input
        userGuess = ""
    }

    //Bestemmer hva som skjer dersom brukeren har riktig svar. Vil legge til poeng dersom riktig, men kun hvis det er brukeres første forsøk på spørsmålet.
    private fun correctAnswer(){
        //Variabel som bestemmer antall poeng som skal gis til bruker.
        var addScore = 0
        //Dersom det er brukerens første forsøk på oppgaven gi et poeng.
        if(firstGuess){
            addScore = 1
        }
        //Sjekker om spiller et over. Dersom det er over, legg til poeng og avslutt spill.
        if(isGameOver()){
            _uiState.update {
                it.copy(
                    score = it.score + addScore,
                    isGameOver = true
                )
            }

        } else {
            //Dersom det ikke er over, legg til poeng og gå til neste spørsmål.
            _uiState.update {
                it.copy(
                    score = it.score + addScore,
                    currentAddition = getNextAddition()
                )
            }
            //Tilbakestiller første forsøk
            firstGuess = true
        }

    }

    //Viser dialogboks dersom bruker ønsker å avslutte spill.
    fun backClick(){
        _uiState.update {
            it.copy(
                quitDialog = true
            )
        }
    }
    //Lukker dialogboksdersom bruker ikke ønsket å avslutte allikevel.
    fun dismissBackClick(){
        _uiState.update {
            it.copy(
                quitDialog = false
            )
        }
    }
    //Bestemmer det som skjer dersom bruker har feil svar. Setter isAnswerWrong til true.
    private fun wrongAnswer(){
        //Brukeren har ikke riktig svar og får derfor ingen poeng.
        firstGuess = false
        _uiState.update {
            it.copy(
                isAnswerWrong = true
            )
        }
    }

    //Sjekker om brukerens svar er lik riktig svar.Vil retunere True dersom riktig.
    //Tar inn brukerens svar og riktig svar.
    private fun checkAnswer(userGuess : String, correctAnswer: String): Boolean{
        return userGuess == correctAnswer
    }

    //Oppdaterer bruker input. Kalles når bruker skriver inn et tall.
    fun updateUserGuess(userAnswer: String){
        userGuess = userAnswer

    }

    //funksjon som kalles når bruker har fått feil og skal forsøke igjen. Setter isAnswerWrong til false.
    fun tryAgain(){
        _uiState.update {
            it.copy(
                isAnswerWrong = false
            )
        }

    }

    //Oppdaterer spill lengde basert på det brukeren har valgt. Setter verdi i GameUiState.
    fun updateGameLength(length: Int) {

        _uiState.update {
            it.copy(
                gameLength = length
            )
        }
    }
    //Kjøres når viewmodel opprettes. Resetter spillet og starter ny runde.
    init {
        resetGame()
    }

    //Sjekker om det finnes flere spørsmål å svare. Dersom det ikke gjør det skal man avslutte spillet.
    //Retunerer True dersom det ikke er flere spørsmål.
    private fun isGameOver(): Boolean {
        return gameAdditions.isEmpty()

    }


}