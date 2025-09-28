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

/**
 * Hoved-navhost for applikasjonen.
 *
 * Dette elementer definerer navigasjonsstrukturen for appen.
 * Den bestemmer hvilken side som skal vises basert på hvilken rute (destination)
 * som er aktiv i [NavHostController].
 *
 * Følgende sider er inkludert:
 * - [HomePage] -> Startskjerm med inngang til spillet og andre valg.
 * - [GamePage] -> Selve spillet, styrt av [GameViewModel].
 * - [AboutPage] -> Viser informasjon om applikasjonen.
 * - [PreferencePage] → Innstillinger for spill og preferanser.
 *
 * @param navController Kontroller som håndterer navigasjon mellom skjermene.
 * @param gameViewModel Delt [GameViewModel] som sørger for at spilldata beholdes
 *                      på tvers av skjermrotasjoner og navigasjon.
 */

@Composable
fun AppNavHost(
    navController: NavHostController,
    gameViewModel: GameViewModel
) {
    NavHost(navController = navController, startDestination = AppPages.Home.name) {

        // Skjermer
        composable(AppPages.Home.name) { HomePage(navController) }
        composable(AppPages.Game.name) { GamePage(navController, gameViewModel) }
        composable(AppPages.About.name) { AboutPage(navController) }
        composable(AppPages.Preference.name) { PreferencePage(navController, gameViewModel) }
    }
}

