package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dave_3600_mappeprosjekt1.ui.pages.AboutPage
import com.example.dave_3600_mappeprosjekt1.ui.pages.GamePage

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "game") {
        composable("home") { HomePage(navController) }
        composable("about") { AboutPage(navController) }
        composable("game") { GamePage(navController) }
    }
}

@Composable
fun HomePage(navController: NavController) {

}
