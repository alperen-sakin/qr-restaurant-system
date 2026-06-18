package com.example.kitchenapp.presentation.historyScreen.viewModel

import com.example.kitchenapp.domain.model.Order

data class HistoryState(
    val compLastedOrders: List<Order> = emptyList(),
)
