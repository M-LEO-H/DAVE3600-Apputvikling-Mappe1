package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.buttons.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.pages.AboutPage
import com.example.dave_3600_mappeprosjekt1.ui.pages.GamePage
import com.example.dave_3600_mappeprosjekt1.ui.pages.PreferencePage

@Composable
fun AppNavHost(
    navController: NavHostController,
    gameViewModel: GameViewModel
) {
    val gameLabel = stringResource(R.string.game)
    val aboutLabel = stringResource(R.string.about)
    val prefLabel = stringResource(R.string.preference)


    NavHost(navController = navController, startDestination = "home") {

        // HOME SCREEN
        composable("home") {
            OptionsScreen(
                options = stringArrayResource(id = R.array.home_screen_options).toList(),
                onOptionClick = { option ->
                    when (option) {
                        gameLabel -> navController.navigate("game")
                        aboutLabel -> navController.navigate("about")
                        prefLabel -> navController.navigate("preference")
                    }
                }
            )
        }

        // OTHER SCREENS
        composable("game") { GamePage(navController, gameViewModel) }
        composable("about") { AboutPage(navController) }
        composable("preference") { PreferencePage(navController, gameViewModel) }
    }
}

