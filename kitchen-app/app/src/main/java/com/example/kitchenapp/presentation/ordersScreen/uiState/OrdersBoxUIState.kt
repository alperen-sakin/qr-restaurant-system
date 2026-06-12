package com.example.kitchenapp.presentation.ordersScreen.uiState

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.kitchenapp.domain.model.OrderItem

data class OrdersBoxUIState(
    val leftBorderColor: Brush,
    val cost: Double,
    val tableNumber: String,
    val date: String,
    val orderNumber: Int,
    val orderItems: List<OrderItem>,
    val buttonText: String,
    val buttonColor: Color,
    val buttonIcon: ImageVector
)
