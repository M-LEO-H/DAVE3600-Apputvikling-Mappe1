package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme

@Composable
fun HomePage(navController: NavHostController){

    OptionsScreen(
        options = stringArrayResource(id = R.array.home_screen_options).toList(),
        onOptionClick = { option ->
            when (option) {
                stringResource(R.string.game) -> navController.navigate("game")
                stringResource(R.string.about) -> navController.navigate("about")
                stringResource(R.string.preference) -> navController.navigate("preference")
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

