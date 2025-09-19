package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dave_3600_mappeprosjekt1.ui.components.OptionsScreen
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme


@Preview(showBackground = true)
@Composable
fun PreviewGameLength() {
    DAVE3600Mappeprosjekt1Theme {
        OptionsScreen(options = listOf("5", "10", "15"))
    }
}