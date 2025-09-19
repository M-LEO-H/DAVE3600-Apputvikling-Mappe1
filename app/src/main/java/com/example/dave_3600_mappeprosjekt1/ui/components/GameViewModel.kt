package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dave_3600_mappeprosjekt1.ui.data.GameUiState
import com.example.dave_3600_mappeprosjekt1.ui.data.getRandomAdditionsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.dave_3600_mappeprosjekt1.ui.data.ShowAddition
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {
    var userGuess by mutableIntStateOf(0)
        private set
    private var _uiState = MutableStateFlow(GameUiState())
    private var allAdditions: MutableList<ShowAddition> = mutableListOf()
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    lateinit var currentAddition: ShowAddition
    val input: State<> get() = userGuess



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

    fun updateUserGuess(userAnswer: Int){
        userGuess = userAnswer
    }


}