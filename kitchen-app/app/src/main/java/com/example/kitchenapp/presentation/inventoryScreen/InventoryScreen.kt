package com.example.kitchenapp.presentation.inventoryScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.kitchenapp.presentation.inventoryScreen.components.InventorItemCard
import com.example.kitchenapp.presentation.inventoryScreen.components.InventoryHeader
import com.example.kitchenapp.presentation.inventoryScreen.constants.getStockStatus
import com.example.kitchenapp.presentation.inventoryScreen.uiState.InventoryItemCardUIState
import com.example.kitchenapp.presentation.inventoryScreen.viewModel.InventoryViewModel

@Composable
fun InventoryScreen(
    modifier: Modifier = Modifier,
    viewModel: InventoryViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        InventoryHeader(
            onAddClick = { /*TODO*/ },
            onSearchValueChange = { viewModel.onSearchValueChange(it) },
            searchValue = state.searchValue
        )

        val status = getStockStatus(quantity = 0, minStockLevel = 10)

        InventorItemCard(
            state = InventoryItemCardUIState(
                imageUrl = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
                quantity = 1,
                itemName = "domates",
                itemNumber = 4,
                unit = "kg",
                icon = status.icon,
                statusTextColor = status.primaryColor,
                statusText = status.status,
                statusBackgroundColor = status.secondaryColor
            )
        )
    }
}
