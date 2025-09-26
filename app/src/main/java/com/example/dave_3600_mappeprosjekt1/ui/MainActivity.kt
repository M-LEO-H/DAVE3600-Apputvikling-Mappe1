package com.example.dave_3600_mappeprosjekt1.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dave_3600_mappeprosjekt1.ui.pages.AboutPage
import com.example.dave_3600_mappeprosjekt1.ui.pages.GamePage
import com.example.dave_3600_mappeprosjekt1.ui.pages.HomePage
import com.example.dave_3600_mappeprosjekt1.ui.pages.PreferencePage
import com.example.dave_3600_mappeprosjekt1.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            AppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController,
                    startDestination = "home")
                {
                    composable("home") {
                        HomePage(navController)
                    }
                    composable("game") {
                        GamePage(navController)
                    }
                    composable("about") {
                        AboutPage(navController)
                    }
                    composable("preference") {
                        PreferencePage(navController)
                    }
                }

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

