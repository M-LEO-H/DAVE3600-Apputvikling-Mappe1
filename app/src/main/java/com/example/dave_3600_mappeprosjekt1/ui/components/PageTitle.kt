package com.example.dave_3600_mappeprosjekt1.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dave_3600_mappeprosjekt1.R
import com.example.dave_3600_mappeprosjekt1.ui.theme.AppTheme

@Composable
fun PageTitle(title: String, modifier: Modifier = Modifier){
    Text(
        title,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold)
}


@Preview(showBackground = true)
@Composable
fun PageTitleView() {
    AppTheme {
        PageTitle(stringResource(id = R.string.preference))
    }
}