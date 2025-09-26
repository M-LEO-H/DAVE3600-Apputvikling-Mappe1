package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dave_3600_mappeprosjekt1.ui.theme.AppTheme


@Composable
fun OptionsScreen(
    modifier: Modifier = Modifier,
    options: List<String>,
    onOptionClick: (String) -> Unit
) {
    Box(modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ) {
        LazyColumn(
                    modifier = modifier
                    .align(Alignment.Center)
        ) {
                items(options) { option ->

                    Button(
                        onClick = { onOptionClick(option)},
                        modifier.width(240.dp),
                        colors = if(option == "Play"){
                                ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.onPrimary
                                )
                            }else{
                                ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.secondary,
                                    contentColor = MaterialTheme.colorScheme.onSecondary
                                )
                            }

                        ) {
                        Text(option)}

                }
            }

    }

}


@Preview
@Composable
fun OptionsScreenPreview() {
    AppTheme {
        OptionsScreen(
            options = listOf("Play", "Option 2", "Option 3"),
            onOptionClick = {}
        )
    }
}


