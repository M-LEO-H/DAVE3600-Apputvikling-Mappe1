package com.example.dave_3600_mappeprosjekt1.ui.components

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

class GameViewModel : ViewModel() {
    var userGuess by mutableStateOf("")
        private set
    private var _uiState = MutableStateFlow(GameUiState())
    private var allAdditions: MutableList<ShowAddition> = mutableListOf()
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    lateinit var currentAddition: ShowAddition






    fun getNextAddition(): ShowAddition? {
        allAdditions = getRandomAdditionsList(uiState.value.gameLength).toMutableList()
        if(allAdditions.isNotEmpty()){
            val nextAddition = allAdditions[0]
            allAdditions.remove(nextAddition)
            currentAddition = nextAddition
            return currentAddition

        } else {
            //TODO gameOver()
           return null
        }
    }


    fun resetGame(){
        _uiState.value = GameUiState(currentAddition = getNextAddition())
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

    fun updateUserGuess(userAnswer: String){
        userGuess = userAnswer
    }


}