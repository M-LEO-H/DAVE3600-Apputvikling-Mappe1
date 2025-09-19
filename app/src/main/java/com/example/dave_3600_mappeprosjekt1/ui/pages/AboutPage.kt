package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.AppNavHost
import com.example.dave_3600_mappeprosjekt1.ui.components.RadioButtonListHorizontal
import com.example.dave_3600_mappeprosjekt1.ui.components.TopBar
import com.example.dave_3600_mappeprosjekt1.ui.components.UnderTitle

@Composable
fun AboutPage(navController: NavController? = null){
    Scaffold(
        topBar = { TopBar(stringResource(id = R.string.aboutTitle),
            onBackClick = {navController?.navigateUp()}) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 40.dp)
                .align(Alignment.CenterHorizontally),
                style = TextStyle(lineHeight = 2.em),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.aboutText))
        }
    }
}

@Preview
@Composable
fun AboutPagePreview(){
    AboutPage()
}