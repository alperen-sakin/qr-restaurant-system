package com.example.kitchenapp.presentation.staffScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kitchenapp.presentation.staffScreen.uiState.StaffCardUIState
import com.example.kitchenapp.ui.theme.ManhattanGray
import com.example.kitchenapp.ui.theme.MatteBlack
import com.example.kitchenapp.ui.theme.PerfectGray

@Composable
fun ButtonSection(
    state: StaffCardUIState,
    onStartClick: () -> Unit,
    onBreakClick: () -> Unit,
    onEndClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomButton(
            icon = Icons.Default.PlayArrow,
            text = "Start",
            color = state.startColor,
            onClick = onStartClick,
            enabled = state.isStartEnabled
        )
        CustomButton(
            icon = Icons.Default.Pause,
            text = "Break",
            color = state.breakColor,
            onClick = onBreakClick,
            enabled = state.isBreakEnabled
        )
        CustomButton(
            icon = Icons.Default.Stop,
            text = "End",
            color = state.endColor,
            onClick = onEndClick,
            enabled = state.isEndEnabled
        )
    }
}

@Composable
private fun CustomButton(
    icon: ImageVector,
    text: String,
    color: Color,
    enabled: Boolean,
    onClick: () -> Unit

) {
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable(enabled = enabled, onClick = onClick)
            .border(
                width = 2.dp,
                color = if (enabled) color else ManhattanGray,
                shape = MaterialTheme.shapes.medium
            )
            .background(color = MatteBlack)
            .padding(vertical = 8.dp, horizontal = 25.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (enabled) color else PerfectGray,
                modifier = Modifier.size(28.dp)
            )

            Text(
                text = text,
                color = if (enabled) color else PerfectGray,
                fontSize = 14.sp
            )
        }
    }
}
