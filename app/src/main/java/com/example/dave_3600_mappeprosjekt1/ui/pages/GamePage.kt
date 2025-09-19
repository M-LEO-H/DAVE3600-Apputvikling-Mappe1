package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.Keyboard
import com.example.dave_3600_mappeprosjekt1.ui.components.TopBar
import com.example.dave_3600_mappeprosjekt1.ui.components.UnderTitle
import com.example.dave_3600_mappeprosjekt1.ui.components.getRandomAdditions
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme


@Composable
fun GamePage(){
    Scaffold(
        topBar = { TopBar(stringResource(id = R.string.game)) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            UnderTitle(stringResource(R.string.game_text))

            val additionList = getRandomAdditions(10)
            var count by remember { mutableIntStateOf(0) }
            val currentQuestion = additionList[count]

            Text("${currentQuestion.a} + ${currentQuestion.b}")
            Text("$count")

            for (item in additionList){
                Text("${item.a} + ${item.b} = ${item.answer}")
            }

            var input by remember {mutableStateOf("")}

            Display(input)

            Keyboard { buttonClick ->
                when (buttonClick) {
                    "DEL" -> {
                        input = input.dropLast(1)
                    }
                    "Angi svar" -> {
                        val isCorrect = checkAnswer(input.toInt(), currentQuestion.answer)
                        if(isCorrect){
                            /*TODO*/
                            count += 1
                            input = ""

                        } else {
                            /*TODO*/
                            count += 100
                            input = ""
                        }
                    }
                    else -> {
                        input += buttonClick
                    }
                }
            }
        }
    }
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
        GamePage()
    }
}