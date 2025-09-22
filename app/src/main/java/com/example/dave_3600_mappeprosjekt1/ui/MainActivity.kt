package com.example.dave_3600_mappeprosjekt1.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dave_3600_mappeprosjekt1.ui.components.GameViewModel
import com.example.dave_3600_mappeprosjekt1.ui.components.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.components.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.pages.GamePage
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DAVE3600Mappeprosjekt1Theme {
                val navController = rememberNavController()
                GamePage(navController = navController )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun GreetingPreview() {
    DAVE3600Mappeprosjekt1Theme {
        Greeting("Android")
    }
}

