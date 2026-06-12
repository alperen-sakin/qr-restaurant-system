package com.example.kitchenapp.presentation.ordersScreen.constants

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Check
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.kitchenapp.ui.theme.DodgerBlue
import com.example.kitchenapp.ui.theme.HotOrange
import com.example.kitchenapp.ui.theme.Malachite
import com.example.kitchenapp.ui.theme.NewGradient
import com.example.kitchenapp.ui.theme.PreparingGradient
import com.example.kitchenapp.ui.theme.ReadyGradient

val String.toButtonColor: Color
    get() = when (this) {
        "pending" -> HotOrange
        "preparing" -> Malachite
        "ready" -> DodgerBlue
        else -> Color.Transparent
    }

val String.toLeftBorderColor: Brush
    get() = when (this) {
        "pending" -> NewGradient
        "preparing" -> PreparingGradient
        "ready" -> ReadyGradient
        else -> SolidColor(Color.Transparent)
    }

val String.toButtonText: String
    get() = when (this) {
        "pending" -> {
            "Prepar"
        }

        "preparing" -> {
            "Ready"
        }

        "ready" -> {
            "Served"
        }

        else -> ""
    }

val String.toButtonIcon: ImageVector
    get() = if (this != "ready") {
        Icons.AutoMirrored.Filled.ArrowForwardIos
    } else {
        Icons.Default.Check
    }
