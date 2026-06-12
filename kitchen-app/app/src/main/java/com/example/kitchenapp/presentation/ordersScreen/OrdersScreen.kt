package com.example.kitchenapp.presentation.ordersScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kitchenapp.presentation.ordersScreen.components.OrderStatusSection
import com.example.kitchenapp.presentation.ordersScreen.constants.DummyData
import com.example.kitchenapp.presentation.ordersScreen.constants.OrderStatusList
import com.example.kitchenapp.presentation.ordersScreen.uiState.OrderSectionUiState
import com.example.kitchenapp.ui.theme.PerfectGray

@Composable
fun OrdersScreen(modifier: Modifier = Modifier) {
    val newOrders = DummyData.filter { it.status == "New" }
    val preparingOrders = DummyData.filter { it.status == "Preparing" }
    val readyOrders = DummyData.filter { it.status == "Ready" }

    Column(
        modifier = modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OrderTitle()

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            OrderStatusList.forEach { item ->
                OrderStatusSection(
                    modifier = Modifier.weight(1f),
                    uiState = OrderSectionUiState(
                        orderStatusTitle = item.title,
                        primaryColor = item.primaryColor,
                        secondaryColor = item.secondaryColor,
                        orders = when (item.title) {
                            "New Orders" -> newOrders
                            "Preparing" -> preparingOrders
                            "Ready" -> readyOrders
                            else -> emptyList()
                        },
                        orderCount = when (item.title) {
                            "New Orders" -> newOrders.size
                            "Preparing" -> preparingOrders.size
                            "Ready" -> readyOrders.size
                            else -> 0
                        }
                    ),
                )
            }
        }
    }
}

@Composable
fun OrderTitle(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Active Orders",
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Follow Orders flow and manage orders",
            fontSize = 14.sp,
            color = PerfectGray
        )
    }
}
