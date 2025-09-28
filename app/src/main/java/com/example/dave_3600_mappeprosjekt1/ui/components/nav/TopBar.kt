package com.example.dave_3600_mappeprosjekt1.ui.components.nav



import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dave_3600_mappeprosjekt1.ui.theme.AppTheme

/**
 * Top bar composable for applikasjonen. Lager en top bar som viser en tittel og en tilbakeknapp brukt for navigasjon.
 * Viser hvor i applikasjonen man befinner seg.
 * @param title Tittel på siden man er på.
 * @param onBackClick Kaller funksjon når trykket på. Brukes for navigasjon.
 *
 */

//Top bar with back button and title
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    onBackClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        //Gir topbar farge.
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            ),
        //Tittel på topbaren.
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )
            },
        //Ikon brukt for å lage en pil som skal signalisere at man kan gå tilbake.
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )
    }




@Preview
@Composable
fun TopBarPreview(){
    AppTheme {
        TopBar("Preference", onBackClick = {})
    }
}