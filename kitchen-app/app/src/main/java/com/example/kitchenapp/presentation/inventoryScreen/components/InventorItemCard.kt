package com.example.kitchenapp.presentation.inventoryScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.kitchenapp.R
import com.example.kitchenapp.presentation.inventoryScreen.uiState.InventoryItemCardUIState
import com.example.kitchenapp.ui.theme.CarbonFiber2
import com.example.kitchenapp.ui.theme.MatteBlack
import com.example.kitchenapp.ui.theme.PerfectGray

@Composable
fun InventorItemCard(
    modifier: Modifier = Modifier,
    state: InventoryItemCardUIState
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MatteBlack,

        ),
        border = BorderStroke(
            width = 2.dp,
            color = CarbonFiber2
        )

    ) {
        ImageSection(state)

        ContentSection(state)
    }
}

@Composable
private fun ContentSection(state: InventoryItemCardUIState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "INV-${state.itemNumber}",
                fontSize = 14.sp,
                color = PerfectGray
            )

            Text(
                text = state.itemName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(CarbonFiber2)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "AVAILABLE STOCK",
                fontWeight = FontWeight.SemiBold,
                color = PerfectGray,
                fontSize = 14.sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "${state.quantity}",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White

                )
                Text(
                    text = state.unit,
                    fontSize = 14.sp,
                    color = PerfectGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 1.dp)
                )
            }
        }
    }
}

@Composable
private fun ImageSection(state: InventoryItemCardUIState) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.TopEnd
    ) {
        AsyncImage(
            model = state.imageUrl,
            contentDescription = null,
            placeholder = painterResource(R.drawable.no_image_found),
            error = painterResource(R.drawable.no_image_found),
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            contentScale = ContentScale.Crop

        )

        Box(
            modifier = Modifier
                .padding(all = 20.dp),
        ) {
            Row(
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.large)
                    .background(color = state.statusBackgroundColor)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = state.icon,
                    contentDescription = null,
                    tint = state.statusTextColor,
                )

                Text(
                    text = state.statusText,
                    color = state.statusTextColor,
                )
            }
        }
    }
}
