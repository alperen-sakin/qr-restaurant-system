package com.example.kitchenapp.presentation.staffScreen.constants

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector

sealed class StaffInfoItems(
    val icon: ImageVector,
    val title: String,
) {
    object Role : StaffInfoItems(
        icon = Icons.Filled.Work,
        title = "Role",
    )
    object Department : StaffInfoItems(
        icon = Icons.Default.Apartment,
        title = "Department",
    )
    object WorkTime : StaffInfoItems(
        icon = Icons.Default.AccessTime,
        title = "Worked Time",
    )
}
