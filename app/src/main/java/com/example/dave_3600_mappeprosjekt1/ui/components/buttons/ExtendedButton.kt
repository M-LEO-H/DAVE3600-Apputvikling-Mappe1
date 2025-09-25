package com.example.dave_3600_mappeprosjekt1.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme

@Composable
fun ExtendedButton(name: String, onClick: () -> Unit) {
    Button(onClick = { onClick() }){
        Text(name)
    }
}


@Preview(showBackground = true)
@Composable
fun ExtendedButtonView() {
    DAVE3600Mappeprosjekt1Theme {
        ExtendedButton("Norwegian") { }
    }
}