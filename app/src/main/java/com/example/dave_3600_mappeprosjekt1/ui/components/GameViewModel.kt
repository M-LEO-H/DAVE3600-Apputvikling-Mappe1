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

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.dave_3600_mappeprosjekt1.ui.data.ShowAddition
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.update

class GameViewModel(application: Application) : AndroidViewModel(application) {
    var userGuess by mutableStateOf("")
        private set
    private var _uiState = MutableStateFlow(GameUiState())
    private var allAdditions: Array<String> = application.resources.getStringArray(R.array.addition_array)
    private lateinit var gameAdditions: MutableList<ShowAddition>
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    lateinit var currentAddition: ShowAddition
    private var firstGuess = true




    private fun getRandomAdditionsList() {

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



    private fun getNextAddition(): ShowAddition? {
        if(gameAdditions.isEmpty()) {
            return null
        }
        //Takes and removes the first class from the list and sets it in currentAddition
        currentAddition = gameAdditions.removeAt(0)
        return currentAddition

    }


    fun resetGame(){
        getRandomAdditionsList()
        userGuess = ""
        _uiState.value = _uiState.value.copy(
            currentAddition = getNextAddition(),
            isAnswerWrong = false,
            isGameOver = false,
            score = 0,
            quitDialog = false
            )

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
        if(checkAnswer(userGuess, currentAddition.answer)){
            correctAnswer()
        } else {
            wrongAnswer()
        }
        userGuess = ""
    }

    private fun correctAnswer(){
        var addScore = 0
        if(firstGuess){
            addScore = 1
        }
        if(isGameOver()){
            _uiState.update { it ->
                it.copy(
                    score = it.score + addScore,
                    isGameOver = true
                )
            }

        } else {
            _uiState.update { it ->
                it.copy(
                    score = it.score + addScore,
                    currentAddition = getNextAddition()
                )
            }
            firstGuess = true
        }

    }

    fun backClick(){
        _uiState.update { it ->
            it.copy(
                quitDialog = true
            )
        }
    }

    fun dismissBackClick(){
        _uiState.update { it ->
            it.copy(
                quitDialog = false
            )
        }
    }
    private fun wrongAnswer(){
        firstGuess = false
        _uiState.update {it ->
            it.copy(
                isAnswerWrong = true
            )
        }
    }
    private fun checkAnswer(userGuess : String, correctAnswer: String): Boolean{
        return userGuess == correctAnswer
    }

    fun updateUserGuess(userAnswer: String){
        userGuess = userAnswer

    }

    fun tryAgain(){
        _uiState.update { it ->
            it.copy(
                isAnswerWrong = false
            )
        }

    }

    fun updateGameLength(length: Int) {

        _uiState.update { it ->
            it.copy(
                gameLength = length
            )
        }
    }
    init {
        resetGame()
    }

    private fun isGameOver(): Boolean {
        return gameAdditions.isEmpty()

    }


}