package com.example.kitchenapp.presentation.ordersScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kitchenapp.presentation.ordersScreen.constants.toButtonColor
import com.example.kitchenapp.presentation.ordersScreen.constants.toButtonIcon
import com.example.kitchenapp.presentation.ordersScreen.constants.toButtonText
import com.example.kitchenapp.presentation.ordersScreen.constants.toLeftBorderColor
import com.example.kitchenapp.presentation.ordersScreen.uiState.OrderSectionUiState
import com.example.kitchenapp.presentation.ordersScreen.uiState.OrdersBoxUIState
import com.example.kitchenapp.presentation.util.toFormattedTime
import com.example.kitchenapp.ui.theme.CarbonFiber
import com.example.kitchenapp.ui.theme.PerfectGray
import com.example.kitchenapp.ui.theme.ShockingBlack

@Composable
fun OrderStatusSection(
    modifier: Modifier = Modifier,
    uiState: OrderSectionUiState,
    onOrderUpdate: (String, String) -> Unit
) {
    Column(
        modifier = modifier
            .border(
                width = 2.dp,
                color = CarbonFiber,
                shape = RoundedCornerShape(16.dp)
            )
            .background(color = ShockingBlack, shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OrderStatusHeader(
            orderStatusTitle = uiState.orderStatusTitle,
            primary = uiState.primaryColor,
            secondary = uiState.secondaryColor,
            orderCount = uiState.orderCount
        )
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .background(CarbonFiber)
                .fillMaxWidth()
        )

        Content(uiState, onOrderUpdate)
    }
}

@Composable
private fun Content(
    uiState: OrderSectionUiState,
    onOrderUpdate: (String, String) -> Unit
) {
    if (uiState.orders.isEmpty()) {
        NoOrderBox()
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(uiState.orders) { item ->
                OrderBox(
                    uiState = OrdersBoxUIState(
                        leftBorderColor = item.status.toLeftBorderColor,
                        cost = item.totalCost,
                        tableNumber = item.tableNumber,
                        date = item.date.toFormattedTime(),
                        orderNumber = item.orderNumber,
                        orderItems = item.orderItems,
                        buttonText = item.status.toButtonText,
                        buttonColor = item.status.toButtonColor,
                        buttonIcon = item.status.toButtonIcon

                    ),
                    onClick = {
                        onOrderUpdate(item.id, item.status)
                    }
                )
            }
        }
    }
}

@Composable
private fun NoOrderBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(color = ShockingBlack, shape = RoundedCornerShape(16.dp))
            .border(
                width = 2.dp,
                color = CarbonFiber,
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No Orders",
            color = PerfectGray,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
private fun OrderStatusHeader(
    modifier: Modifier = Modifier,
    orderStatusTitle: String,
    primary: Color,
    secondary: Color,
    orderCount: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(color = primary, shape = CircleShape)
            )

            Text(
                text = orderStatusTitle,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = primary.copy(alpha = 0.5f),
                    shape = CircleShape
                )
                .background(color = secondary, shape = CircleShape)
                .padding(vertical = 1.dp, horizontal = 10.dp),

        ) {
            Text(
                text = orderCount.toString(),
                color = primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}
