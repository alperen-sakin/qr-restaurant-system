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
    val workedTime: String,
    val startColor: Color,
    val breakColor: Color,
    val endColor: Color,
    val isStartEnabled: Boolean,
    val isBreakEnabled: Boolean,
    val isEndEnabled: Boolean,

)
