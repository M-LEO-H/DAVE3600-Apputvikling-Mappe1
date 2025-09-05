package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.RadioButtonListHorizontal
import com.example.dave_3600_mappeprosjekt1.ui.components.TopBar
import com.example.dave_3600_mappeprosjekt1.ui.components.UnderTitle
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme


@Composable
fun PreferencePage(){
    Scaffold(
        topBar = { TopBar(stringResource(id = R.string.preference) )}
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            UnderTitle(stringResource(id = R.string.preferenceText))
            RadioButtonListHorizontal(listOf("Norsk", "Tysk"))
        }
    }
}


@Preview(name = "English")
@Preview(name = "Norsk", locale = "nb")
@Preview(name = "German", locale = "de")
@Composable
fun PreferencePagePreview() {
    DAVE3600Mappeprosjekt1Theme {
        PreferencePage()
    }
}