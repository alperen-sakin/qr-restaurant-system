package com.example.kitchenapp.presentation.staffScreen.uiState

import androidx.compose.ui.graphics.Color

data class StaffCardUIState(
    val imageUrl: String,
    val statusColor: Color,
    val secondaryColor: Color,
    val staffName: String,
    val statusText: String,
    val department: String,
    val role: String,
    val workedTime: String

)
