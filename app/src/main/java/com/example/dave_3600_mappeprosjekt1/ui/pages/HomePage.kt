package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dave_3600_mappeprosjekt1.ui.components.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme

@Composable
fun HomePage(){

    OptionsScreen(options = listOf("Play", "Informasjon", "Preferanser"))
}





@Preview(showBackground = true)
@Composable
fun PreviewOptionsScreen() {
    DAVE3600Mappeprosjekt1Theme {
        HomePage()
    }
}

