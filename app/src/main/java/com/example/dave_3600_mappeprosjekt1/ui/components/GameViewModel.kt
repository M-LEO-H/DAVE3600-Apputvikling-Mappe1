package com.example.dave_3600_mappeprosjekt1.ui.components

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringArrayResource
import androidx.lifecycle.ViewModel
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.data.GameUiState
import com.example.dave_3600_mappeprosjekt1.ui.data.getRandomAdditionsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.dave_3600_mappeprosjekt1.ui.data.ShowAddition
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.AndroidViewModel
import com.example.dave_3600_mappeprosjekt1.ui.pages.checkAnswer
import kotlinx.coroutines.flow.update

class GameViewModel(application: Application) : AndroidViewModel(application) {
    var userGuess by mutableStateOf("")
        private set
    private var _uiState = MutableStateFlow(GameUiState())
    private var allAdditions: Array<String> = application.resources.getStringArray(R.array.addition_array)
    private lateinit var gameAdditions: MutableList<ShowAddition>
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    lateinit var currentAddition: ShowAddition




    fun getRandomAdditionsList() {

        gameAdditions = allAdditions
            .toList()
            .shuffled()
            .take(_uiState.value.gameLength)
            .map { str ->
                val parts = str.split(",")
                ShowAddition(
                    a = parts[0],
                    b = parts[1],
                    answer = parts[2]
                )
            }.toMutableList()
    }



    fun getNextAddition(): ShowAddition {
        if(gameAdditions.isEmpty()) {
            return ShowAddition("","","")
        }
        //Takes and removes the first class from the list and sets it in currentAddition
        currentAddition = gameAdditions.removeAt(0)
        return currentAddition

    }


    fun resetGame(){
        getRandomAdditionsList()
        userGuess = ""
        _uiState.value = GameUiState(currentAddition = getNextAddition())
        _uiState.value = GameUiState(isAnswerWrong = false)
        _uiState.value = GameUiState(score = 0)

    }

    init{
        resetGame()
    }



    fun addDigit(digit: String) {
        userGuess += digit
    }

    fun deleteLast() {
       if(userGuess.isNotEmpty()){
           userGuess = userGuess.dropLast(1)
       }
    }

    fun submitAnswer(){
        if(userGuess.isNotEmpty()){
            if(checkAnswer(userGuess, currentAddition.answer)){
                userGuess = ""
                _uiState.update { it ->
                    it.copy(
                        score = it.score + 1,
                        currentAddition = getNextAddition()
                    )
                }


            } else {
                /*TODO*/
                _uiState.update { it ->
                    it.copy(
                        isAnswerWrong = true
                    )
                }

            }

        }

        /*TODO*/

    }

    fun checkAnswer(userGuess : String, correctAnswer: String): Boolean{
        return userGuess == correctAnswer
    }

    fun updateUserGuess(userAnswer: String){
        userGuess = userAnswer

    }

    fun updateGameLength(length: Int) {
        _uiState.value = _uiState.value.copy(gameLength = length)
    }


}