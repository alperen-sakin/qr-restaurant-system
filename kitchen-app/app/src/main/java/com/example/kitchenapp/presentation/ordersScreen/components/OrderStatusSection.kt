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
import com.example.kitchenapp.ui.theme.CarbonFiber
import com.example.kitchenapp.ui.theme.PerfectGray
import com.example.kitchenapp.ui.theme.ShockingBlack

@Composable
fun OrderStatusSection(
    modifier: Modifier = Modifier,
    orderStatusTitle: String,
    primaryColor: Color,
    secondaryColor: Color
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
            orderStatusTitle = orderStatusTitle,
            primary = primaryColor,
            secondary = secondaryColor
        )
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .background(CarbonFiber)
                .fillMaxWidth()
        )

        NoOrderBox()

        OrderBox()
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
    secondary: Color
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
                text = "0",
                color = primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}
