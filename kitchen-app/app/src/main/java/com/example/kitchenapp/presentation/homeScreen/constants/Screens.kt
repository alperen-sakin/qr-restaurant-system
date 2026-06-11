package com.example.kitchenapp.presentation.homeScreen.constants

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Orders : Screens(route = "orders", title = "Orders", Icons.Default.Restaurant)
    object History : Screens(route = "history", title = "History", Icons.Default.History)
    object Inventory : Screens(route = "inventory", title = "Inventory", Icons.Default.Inventory2)
    object Staff : Screens(route = "staff", title = "Staff", Icons.Default.Group)
}
