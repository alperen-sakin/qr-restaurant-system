package com.example.kitchenapp.presentation.ordersScreen.uiState

import androidx.compose.ui.graphics.Color
import com.example.kitchenapp.domain.model.Order

data class OrderSectionUiState(
    val orderStatusTitle: String,
    val primaryColor: Color,
    val secondaryColor: Color,
    val orders: List<Order>,
    val orderCount: Int,
)
