package com.example.kitchenapp.presentation.inventoryScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLocale
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.kitchenapp.presentation.inventoryScreen.components.InventorItemCard
import com.example.kitchenapp.presentation.inventoryScreen.components.InventoryHeader
import com.example.kitchenapp.presentation.inventoryScreen.constants.getStockStatus
import com.example.kitchenapp.presentation.inventoryScreen.uiState.InventoryItemCardUIState
import com.example.kitchenapp.presentation.inventoryScreen.viewModel.InventoryViewModel

const val GRID_SPAN_COUNT = 4

@Composable
fun InventoryScreen(
    modifier: Modifier = Modifier,
    viewModel: InventoryViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val filteredInventoryItems = state.inventoryItems.filter { item ->
        item.itemName.lowercase(LocalLocale.current.platformLocale).contains(
            state.searchValue.lowercase(
                LocalLocale.current.platformLocale
            )
        )
    }
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        InventoryHeader(
            onAddClick = { /*TODO*/ },
            onSearchValueChange = { viewModel.onSearchValueChange(it) },
            searchValue = state.searchValue
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(GRID_SPAN_COUNT),
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            items(filteredInventoryItems) { item ->
                val status = getStockStatus(item.quantity, item.minStockLevel)

                InventorItemCard(
                    state = InventoryItemCardUIState(
                        imageUrl = item.imgUrl,
                        itemNumber = item.itemNumber,
                        itemName = item.itemName,
                        quantity = item.quantity,
                        unit = item.unit,
                        icon = status.icon,
                        statusText = status.status,
                        statusTextColor = status.primaryColor,
                        statusBackgroundColor = status.secondaryColor
                    ),
                )
            }
        }
    }
}
