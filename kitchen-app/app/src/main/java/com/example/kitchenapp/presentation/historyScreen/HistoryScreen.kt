package com.example.kitchenapp.presentation.historyScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.kitchenapp.presentation.historyScreen.components.HistoryDataSection
import com.example.kitchenapp.presentation.historyScreen.components.HistoryHeader
import com.example.kitchenapp.presentation.historyScreen.viewModel.HistoryViewModel

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    var searchValue by remember { mutableStateOf("") }

    val state by viewModel.state.collectAsState()
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        HistoryHeader(
            searchValue = searchValue,
            onSearchValueChange = {
                searchValue = it
            }
        )

        HistoryDataSection(
            compLastedOrders = state.compLastedOrders
        )
    }
}
