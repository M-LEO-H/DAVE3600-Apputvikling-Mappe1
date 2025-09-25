package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.buttons.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.theme.AppTheme

@Composable
fun HomePage(navController: NavHostController){
    val gameLabel = stringResource(R.string.game)
    val aboutLabel = stringResource(R.string.about)
    val prefLabel = stringResource(R.string.preference)

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




@Preview(showBackground = true)
@Composable
fun PreviewHomePage() {
    val context = LocalContext.current
    val fakeNavController = rememberNavController() // Works in preview
    AppTheme {
        HomePage(navController = fakeNavController)
    }
}

