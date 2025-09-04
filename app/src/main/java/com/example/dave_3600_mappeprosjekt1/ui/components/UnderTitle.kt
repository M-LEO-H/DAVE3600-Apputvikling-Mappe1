package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dave_3600_mappeprosjekt1.ui.theme.DAVE3600Mappeprosjekt1Theme

@Composable
fun UnderTitle(text: String, modifier: Modifier = Modifier){
    Text(
        text,
        fontSize = 20.sp,
        color = Color.Gray
    )

}

@Preview(showBackground = true)
@Composable
fun UnderTitleView() {
    DAVE3600Mappeprosjekt1Theme {
        UnderTitle("Velg språk")
    }
}