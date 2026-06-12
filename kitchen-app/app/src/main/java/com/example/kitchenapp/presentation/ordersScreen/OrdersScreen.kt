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
import com.example.kitchenapp.presentation.ordersScreen.constants.OrderStatusList
import com.example.kitchenapp.ui.theme.PerfectGray

@Composable
fun OrdersScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(20.dp)
    ) {
        OrderTitle()

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OrderStatusList.forEachIndexed { index, item ->
                OrderStatusSection(
                    modifier = Modifier.weight(1f),
                    orderStatusTitle = item.title,
                    primaryColor = item.primaryColor,
                    secondaryColor = item.secondaryColor
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
