package com.example.dave_3600_mappeprosjekt1.ui.data


/**
 * Dataklasse som holder på data som brukes i spillet.
 * For å sørge for at default verdier ikke endres, vil selve spillet lage en egen kopi av denne klassen.
 * @param gameLength Velger lengde på spillet. Default verdi er 5.
 * @param currentAddition Spørsmålet som skal besvares nå.
 * @param isAnswerWrong Sier om svar er feil.
 * @param isGameOver Sier om spillet er over.
 * @param score Antall poeng bruker har.
 * @param quitDialog Bestemmer om dialogboks skal vises. Brukes når brukeren vil avslutte før spillet er ferdig.
 *
 *
 *
 *
 */
data class GameUiState(
    val gameLength: Int = 5,
    val currentAddition: ShowAddition? = null,
    val isAnswerWrong: Boolean = false,
    val isGameOver: Boolean = false,
    val score: Int = 0,
    val quitDialog: Boolean = false
)
