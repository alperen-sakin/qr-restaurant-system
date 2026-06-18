package com.example.kitchenapp.presentation.inventoryScreen.uiState

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class InventoryItemCardUIState(
    val imageUrl: String = "",
    val itemNumber: Int = 0,
    val itemName: String = "",
    val quantity: Int = 0,
    val unit: String = "",
    val icon: ImageVector,
    val statusTextColor: Color,
    val statusText: String,
    val statusBackgroundColor: Color
)
