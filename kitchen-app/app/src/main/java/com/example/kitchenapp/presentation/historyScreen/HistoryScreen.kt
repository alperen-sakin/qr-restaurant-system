package com.example.kitchenapp.presentation.historyScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kitchenapp.presentation.historyScreen.components.HistoryHeader

@Composable
fun HistoryScreen(modifier: Modifier = Modifier) {
    var searchValue by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        HistoryHeader(
            searchValue = searchValue,
            onSearchValueChange = {
                searchValue = it
            }
        )
    }
}
