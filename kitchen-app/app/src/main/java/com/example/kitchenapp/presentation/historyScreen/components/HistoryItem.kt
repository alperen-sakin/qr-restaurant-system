package com.example.kitchenapp.presentation.historyScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kitchenapp.presentation.historyScreen.uiState.BadgeCellUiState
import com.example.kitchenapp.ui.theme.Bush
import com.example.kitchenapp.ui.theme.DarkGrey
import com.example.kitchenapp.ui.theme.LuxuryGreen
import com.example.kitchenapp.ui.theme.Malachite
import com.example.kitchenapp.ui.theme.PerfectGray

private const val DEFAULT_WEIGHT = 1f
private const val SECONDARY_WEIGHT = 1.5f

@Composable
fun HistoryItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(horizontal = 32.dp, vertical = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconTextCell(
            modifier = Modifier.weight(DEFAULT_WEIGHT),
            icon = Icons.AutoMirrored.Filled.Assignment,
            text = "ORD-005",
            textColor = Color.White,
            fontWeight = FontWeight.Bold
        )

        IconTextCell(
            modifier = Modifier.weight(SECONDARY_WEIGHT),
            icon = Icons.Default.CalendarToday,
            text = "18 Haz 2026 00:45",
            textColor = PerfectGray,
            fontWeight = FontWeight.Medium
        )

        Text(
            modifier = Modifier.weight(DEFAULT_WEIGHT),
            text = "Table 1",
            color = PerfectGray,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )

        BadgeCell(
            modifier = Modifier.weight(DEFAULT_WEIGHT),
            state = BadgeCellUiState(
                text = "1 Product",
                textColor = Color.White,
                borderColor = Bush,
                backgroundColor = DarkGrey,
                shape = MaterialTheme.shapes.medium,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            modifier = Modifier.weight(DEFAULT_WEIGHT),
            text = "$18.00",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        BadgeCell(
            modifier = Modifier.weight(DEFAULT_WEIGHT),
            state = BadgeCellUiState(
                text = "Completed",
                textColor = Color.White,
                borderColor = Malachite,
                backgroundColor = LuxuryGreen,
                shape = MaterialTheme.shapes.medium,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
private fun IconTextCell(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String,
    textColor: Color,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = PerfectGray,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            color = textColor,
            fontWeight = fontWeight,
            fontSize = 16.sp
        )
    }
}

@Composable
private fun BadgeCell(
    modifier: Modifier = Modifier,
    state: BadgeCellUiState
) {
    Box(
        modifier = modifier.wrapContentWidth(Alignment.Start)
    ) {
        Box(
            modifier = Modifier
                .clip(shape = state.shape)
                .border(width = 1.dp, color = state.borderColor, shape = state.shape)
                .background(color = state.backgroundColor)
                .padding(vertical = 10.dp, horizontal = 20.dp)
        ) {
            Text(
                text = state.text,
                color = state.textColor,
                fontSize = 15.sp,
                fontWeight = state.fontWeight
            )
        }
    }
}
