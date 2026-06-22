package com.example.kitchenapp.presentation.staffScreen.constants

import androidx.compose.ui.graphics.Color
import com.example.kitchenapp.ui.theme.CarbonFiber2
import com.example.kitchenapp.ui.theme.HotOrange
import com.example.kitchenapp.ui.theme.Malachite
import com.example.kitchenapp.ui.theme.ManhattanGray

sealed class StaffStatus(
    val statusColor: Color,
    val secondaryColor: Color,
) {
    object OnWorking : StaffStatus(
        statusColor = Malachite,
        secondaryColor = Malachite.copy(alpha = 0.5f)
    )

    object OnBreak : StaffStatus(
        statusColor = HotOrange,
        secondaryColor = HotOrange.copy(alpha = 0.5f)

    )

    object OnLeave : StaffStatus(
        statusColor = ManhattanGray,
        secondaryColor = CarbonFiber2

    )
}

fun getStaffStatus(status: String): StaffStatus {
    return when (status) {
        "working" -> StaffStatus.OnWorking
        "on_break" -> StaffStatus.OnBreak
        else -> StaffStatus.OnLeave
    }
}
