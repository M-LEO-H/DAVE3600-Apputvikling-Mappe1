package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.buttons.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.data.AppPages


/**
 * Hjemmesiden for appen.
 * Viser appnavn og navigasjonsknappene til de andre sidene
 * @param navController Navigeringskontroller for navigasjon
 */
@Composable
fun HomePage(navController: NavHostController){
    //Henter array med navigasjonsknappene
    val optionsLabels = stringArrayResource(id = R.array.navigation_screen_options).toList()

    //Mapper labels til AppPages og lager en liste med labels og AppPages
    val options = listOf(
        optionsLabels[1] to AppPages.Game,
        optionsLabels[2] to AppPages.About,
        optionsLabels[3] to AppPages.Preference
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
       Text(
            stringResource(R.string.game_name)
       )
        Spacer(modifier = Modifier.padding(16.dp))

        //Viser navigasjonsknappene
        OptionsScreen(
            options = options.map { it.first },
            onOptionClick = { clickedLabel ->
                options.find { it.first == clickedLabel }?.second?.let {
                    navController.navigate(it.name)
                }
            }
        )
    }




}

/*
@Preview(showBackground = true)
@Composable
fun PreviewHomePage() {
    val context = LocalContext.current
    val fakeNavController = rememberNavController() // Works in preview
    AppTheme {
        HomePage(navController = fakeNavController)
    }
}
*/

