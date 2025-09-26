package com.example.dave_3600_mappeprosjekt1.ui.components.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dave_3600_mappeprosjekt1.ui.components.GameViewModel
import com.example.dave_3600_mappeprosjekt1.ui.data.AppPages
import com.example.dave_3600_mappeprosjekt1.ui.pages.AboutPage
import com.example.dave_3600_mappeprosjekt1.ui.pages.GamePage
import com.example.dave_3600_mappeprosjekt1.ui.pages.HomePage
import com.example.dave_3600_mappeprosjekt1.ui.pages.PreferencePage

@Composable
fun AppNavHost(
    navController: NavHostController,
    gameViewModel: GameViewModel
) {
    NavHost(navController = navController, startDestination = AppPages.Home.name) {

        // HOME SCREEN
        composable(AppPages.Home.name) { HomePage(navController) }

        // OTHER SCREENS
        composable(AppPages.Game.name) { GamePage(navController, gameViewModel) }
        composable(AppPages.About.name) { AboutPage(navController) }
        composable(AppPages.Preference.name) { PreferencePage(navController, gameViewModel) }
    }
}

