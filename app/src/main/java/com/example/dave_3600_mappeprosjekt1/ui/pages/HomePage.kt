package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.buttons.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.data.AppPages
import com.example.dave_3600_mappeprosjekt1.ui.theme.AppTheme

@Composable
fun HomePage(navController: NavHostController){
    val optionsLabels = stringArrayResource(id = R.array.navigation_screen_options).toList()


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




@Preview(showBackground = true)
@Composable
fun PreviewHomePage() {
    val context = LocalContext.current
    val fakeNavController = rememberNavController() // Works in preview
    AppTheme {
        HomePage(navController = fakeNavController)
    }
}

