package com.example.kitchenapp.presentation.ordersScreen.uiState

import androidx.compose.ui.graphics.Brush
import com.example.kitchenapp.domain.model.OrderItem

data class OrdersBoxUIState(
    val leftBorderColor: Brush,
    val cost: Double,
    val tableNumber: String,
    val date: String,
    val orderNumber: String,
    val orderItems: List<OrderItem>
)
