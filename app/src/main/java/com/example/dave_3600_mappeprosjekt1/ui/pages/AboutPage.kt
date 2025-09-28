package com.example.dave_3600_mappeprosjekt1.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.components.nav.TopBar


/**
 * Skjermbilde som viser "Om"-siden av applikasjonen.
 * Bruker en scaffold for å skaffe et standard layout, med en Topbar.
 * Innholdet er et kort som inneholder en tekst om applikasjonen.
 * @param navController Brukes for å navigere til andre skjermer.
 *
 *
 */
@Composable
fun AboutPage(navController: NavController? = null){
    Scaffold(
        //Gir tittel og tilbake-knapp
        topBar = { TopBar(stringResource(id = R.string.aboutTitle),
            onBackClick = {navController?.navigateUp()}) }
    ) { innerPadding ->
        //Innholdet til skjermen.
        Column(
            //Legger på padding for alle sider.
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            //Sentrerer innholdet
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //Skaper bakgrunn for teksten
            Card(
                modifier = Modifier.padding(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            ) {
                //Viser selve teksten
                Text(
                    modifier = Modifier.fillMaxWidth()
                        //Skaper padding på alle sider
                        .padding(horizontal = 40.dp, vertical = 40.dp)
                        //Sentrerer teksten
                        .align(Alignment.CenterHorizontally),
                    style = TextStyle(lineHeight = 2.em),
                    textAlign = TextAlign.Center,
                    //Henter string fra strings.xml
                    text = stringResource(id = R.string.aboutText)
                )
            }
        }
    }
}

@Preview
@Composable
fun AboutPagePreview(){
    AboutPage()
}