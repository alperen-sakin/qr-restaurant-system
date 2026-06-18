package com.example.kitchenapp.presentation.historyScreen.uiState

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight

data class BadgeCellUiState(
    val text: String,
    val textColor: Color,
    val borderColor: Color,
    val backgroundColor: Color,
    val shape: Shape,
    val fontWeight: FontWeight = FontWeight.Normal
)
