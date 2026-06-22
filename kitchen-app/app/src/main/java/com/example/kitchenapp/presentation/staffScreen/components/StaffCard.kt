package com.example.kitchenapp.presentation.staffScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.kitchenapp.presentation.staffScreen.uiState.StaffCardUIState
import com.example.kitchenapp.ui.theme.MatteBlack

@Composable
fun StaffCard(
    modifier: Modifier = Modifier,
    state: StaffCardUIState,
    onStartClick: () -> Unit,
    onBreakClick: () -> Unit,
    onEndClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MatteBlack
        )

    ) {
        StaffCardHeader(
            state = state
        )

        StaffInfoBox(
            departmentText = state.department,
            roleText = state.role,
            workedTime = state.workedTime
        )

        ButtonSection(
            state = state,
            onStartClick = onStartClick,
            onBreakClick = onBreakClick,
            onEndClick = onEndClick,

        )
    }
}

@Composable
private fun StaffCardHeader(
    modifier: Modifier = Modifier,
    state: StaffCardUIState
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(16.dp)
    ) {
        StaffAvatar(state, modifier)

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = state.staffName,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 18.sp
            )

            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = state.statusColor,
                        shape = CircleShape
                    )
                    .background(color = state.secondaryColor, shape = CircleShape)
                    .padding(vertical = 1.dp, horizontal = 10.dp),

            ) {
                Text(
                    text = state.statusText,
                    color = state.statusColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}

@Composable
private fun StaffAvatar(
    state: StaffCardUIState,
    modifier: Modifier
) {
    val glowBrush = Brush.radialGradient(
        colors = listOf(
            state.statusColor.copy(alpha = 0.5f),
            state.statusColor.copy(alpha = 0.0f)
        )
    )
    Box(
        modifier = modifier
            .size(75.dp)
            .drawStatusRing(
                statusColor = state.statusColor,
                glowBrush = glowBrush
            )

    ) {
        AsyncImage(
            model = state.imageUrl,
            contentDescription = "Staff Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}
