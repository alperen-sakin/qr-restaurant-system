package com.example.kitchenapp.presentation.historyScreen.uiState

data class HistoryItemUIState(
    val orderNumber: Int,
    val tableNumber: String,
    val productCount: Int,
    val totalPrice: Double,
    val date: String
)
