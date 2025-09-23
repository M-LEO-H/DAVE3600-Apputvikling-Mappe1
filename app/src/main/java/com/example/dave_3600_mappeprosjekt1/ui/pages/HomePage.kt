package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dave_3600_mappeprosjekt1.ui.components.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme

@Composable
fun HomePage(navController: NavHostController){

    OptionsScreen(
        options = listOf("Play", "Informasjon", "Preferanser"),
        onOptionClick = { option ->
            when (option) {
                "Play" -> navController.navigate("game")
                "Information" -> navController.navigate("about")
                "Preference" -> navController.navigate("preference")
            }
        }
    )
}




@Preview(showBackground = true)
@Composable
fun PreviewHomePage() {
    val context = LocalContext.current
    val fakeNavController = rememberNavController() // Works in preview
    DAVE3600Mappeprosjekt1Theme {
        HomePage(navController = fakeNavController)
    }
}

