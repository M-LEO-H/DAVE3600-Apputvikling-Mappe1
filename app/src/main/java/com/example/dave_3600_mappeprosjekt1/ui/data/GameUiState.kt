package com.example.dave_3600_mappeprosjekt1.ui.data

data class GameUiState(
    val gameLength: Int = 5,
    val currentAddition: ShowAddition? = null,
    val isAnswerWrong: Boolean = false,
    val isGameOver: Boolean = false,
    val score: Int = 0,
)
