package com.example.dave_3600_mappeprosjekt1.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.dave_3600_mappeprosjekt1.ui.components.nav.AppNavHost
import com.example.dave_3600_mappeprosjekt1.ui.components.GameViewModel
import com.example.dave_3600_mappeprosjekt1.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val gameViewModel: GameViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory(application)
            )

            AppTheme {
                AppNavHost(navController, gameViewModel)

                /*NavHost(
                    navController,
                    startDestination = "home")
                {
                    composable("home") {
                        HomePage(navController)
                    }
                    composable("game") {
                        GamePage(navController, gameViewModel)
                    }
                    composable("about") {
                        AboutPage(navController)
                    }
                    composable("preference", ) {
                        PreferencePage(navController, gameViewModel)
                    }
                }*/

            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    AppTheme {

    }
}

