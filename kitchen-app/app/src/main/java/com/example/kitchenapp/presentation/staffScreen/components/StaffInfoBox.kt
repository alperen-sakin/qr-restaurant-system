package com.example.kitchenapp.presentation.staffScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.kitchenapp.presentation.staffScreen.constants.StaffInfoItems
import com.example.kitchenapp.ui.theme.PerfectGray
import com.example.kitchenapp.ui.theme.TrueBlack

@Composable
fun StaffInfoBox(
    departmentText: String,
    roleText: String,
    workedTime: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(TrueBlack, shape = MaterialTheme.shapes.medium)
    ) {
        StaffInfoRow(
            subText = departmentText,
            title = StaffInfoItems.Department.title,
            icon = StaffInfoItems.Department.icon
        )

        StaffInfoRow(
            subText = roleText,
            title = StaffInfoItems.Role.title,
            icon = StaffInfoItems.Role.icon
        )
        StaffInfoRow(
            subText = workedTime,
            title = StaffInfoItems.WorkTime.title,
            icon = StaffInfoItems.WorkTime.icon
        )
    }
}

@Composable
private fun StaffInfoRow(
    subText: String,
    title: String,
    icon: ImageVector
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = PerfectGray
            )

            Text(
                text = title,
                color = PerfectGray
            )
        }

        Text(
            text = subText,
            color = Color.White
        )
    }
}
