package com.example.kitchenapp.presentation.staffScreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kitchenapp.presentation.staffScreen.uiState.StaffCardUIState
import com.example.kitchenapp.ui.theme.MatteBlack

@Composable
fun StaffCard(
    modifier: Modifier = Modifier,
    state: StaffCardUIState
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
    }
}

@Composable
fun StaffCardHeader(
    modifier: Modifier = Modifier,
    state: StaffCardUIState
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        StaffAvatar(state, modifier)
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
