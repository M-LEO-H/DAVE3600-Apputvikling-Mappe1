package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

            val additionList = getRandomAdditions(5)
            var count = 0

            val currentQuestion = remember {additionList[count]}

            Text("${currentQuestion.a} + ${currentQuestion.b}")

            /*for (item in additionList){
                Text("${item.a} + ${item.b} = ${item.answer}")
            } */

            var input by remember {mutableStateOf("")}

            Display(input)

            Keyboard { buttonClick ->
                if(buttonClick == "Angi svar" || buttonClick == "DEL"){
                    /*TODO checkAnswer(input) */
                    if(buttonClick == "DEL"){
                        input = input.dropLast(1)

                    } else {
                        val isCorrect = checkAnswer(input.toInt(), currentQuestion.answer)
                            if(isCorrect){
                                count++

                            /*TODO*/
                         } else {
                            /*TODO*/
                        }

                    }


                }
                input += buttonClick

            }
        }

    }
}


fun checkAnswer
            (input: Int,
             correctAnswer: Int,
): Boolean {
    if(input == correctAnswer){
        return true
    }
    else return false
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