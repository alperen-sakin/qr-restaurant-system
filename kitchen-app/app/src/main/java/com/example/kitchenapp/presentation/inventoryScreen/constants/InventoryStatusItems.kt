package com.example.kitchenapp.presentation.inventoryScreen.constants

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.kitchenapp.ui.theme.HotOrange
import com.example.kitchenapp.ui.theme.Malachite
import com.example.kitchenapp.ui.theme.RedAura

sealed class InventoryStatusItems(
    val status: String,
    val primaryColor: Color,
    val secondaryColor: Color,
    val icon: ImageVector
) {
    object InStock : InventoryStatusItems(
        status = "In Stock",
        primaryColor = Malachite,
        secondaryColor = Color.Black.copy(alpha = 0.5f),
        icon = Icons.Default.CheckCircleOutline

    )

    object LowStock : InventoryStatusItems(
        status = "Low Stock",
        primaryColor = HotOrange,
        secondaryColor = Color.Black.copy(alpha = 0.5f),
        icon = Icons.Default.ErrorOutline
    )

    object OutOfStock : InventoryStatusItems(
        status = "Out of Stock",
        primaryColor = RedAura,
        secondaryColor = Color.Black.copy(alpha = 0.5f),
        icon = Icons.Default.Cancel
    )
}

fun getStockStatus(quantity: Int, minStockLevel: Int): InventoryStatusItems {
    return when {
        quantity <= 0.0 -> InventoryStatusItems.OutOfStock
        quantity <= minStockLevel -> InventoryStatusItems.LowStock
        else -> InventoryStatusItems.InStock
    }
}
