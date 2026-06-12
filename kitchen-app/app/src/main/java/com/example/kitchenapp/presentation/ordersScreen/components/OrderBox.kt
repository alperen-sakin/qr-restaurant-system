package com.example.kitchenapp.presentation.ordersScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kitchenapp.domain.model.OrderItem
import com.example.kitchenapp.presentation.ordersScreen.uiState.OrdersBoxUIState
import com.example.kitchenapp.ui.theme.CarbonFiber
import com.example.kitchenapp.ui.theme.CarbonFiber2
import com.example.kitchenapp.ui.theme.EerieBlack
import com.example.kitchenapp.ui.theme.HotOrange
import com.example.kitchenapp.ui.theme.MatteBlack
import com.example.kitchenapp.ui.theme.PerfectGray

@Composable
fun OrderBox(
    uiState: OrdersBoxUIState,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = CarbonFiber,
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
            .background(color = CarbonFiber2)
            .drawBehind {
                val strokeWidth = 10.dp.toPx()
                drawLine(
                    brush = uiState.leftBorderColor,
                    start = Offset(0f, 0f),
                    end = Offset(1f, size.width),
                    strokeWidth = strokeWidth
                )
            }
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        OrderBoxHeader(
            tableNumber = uiState.tableNumber,
            date = uiState.date,
            orderNumber = uiState.orderNumber
        )

        ProductBox(orderItems = uiState.orderItems)

        CheckSection(
            onClick = onClick,
            uiState = uiState
        )
    }
}

@Composable
private fun CheckSection(
    modifier: Modifier = Modifier,
    uiState: OrdersBoxUIState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$${uiState.cost}",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = uiState.buttonColor,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.large,
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = uiState.buttonText,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )

                Icon(
                    imageVector = uiState.buttonIcon,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
private fun ProductBox(
    modifier: Modifier = Modifier,
    orderItems: List<OrderItem>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = EerieBlack, shape = RoundedCornerShape(16.dp))
            .border(
                width = 2.dp,
                color = CarbonFiber,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        orderItems.forEach { item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(color = HotOrange, shape = CircleShape)
                )
                Text(
                    text = "${item.quantity}x ${item.name}",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}

@Composable
private fun OrderBoxHeader(
    tableNumber: String,
    date: String,
    orderNumber: Int,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "ORD-$orderNumber",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = "Table $tableNumber",
                color = PerfectGray,
                fontSize = 14.sp
            )
        }

        Row(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = CarbonFiber,
                    shape = MaterialTheme.shapes.medium
                )
                .background(color = MatteBlack, shape = MaterialTheme.shapes.medium)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccessTime,
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = date,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}
