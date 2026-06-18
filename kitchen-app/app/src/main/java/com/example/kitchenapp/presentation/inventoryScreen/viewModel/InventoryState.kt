package com.example.kitchenapp.presentation.inventoryScreen.viewModel

import com.example.kitchenapp.domain.model.InventoryItem

data class InventoryState(
    val searchValue: String = "",
    val inventoryItems: List<InventoryItem> = emptyList()

)
