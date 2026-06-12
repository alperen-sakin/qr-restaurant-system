package com.example.kitchenapp.presentation.ordersScreen.constants

import androidx.compose.ui.graphics.Color
import com.example.kitchenapp.ui.theme.Aztec
import com.example.kitchenapp.ui.theme.CoffeeBean
import com.example.kitchenapp.ui.theme.DodgerBlue
import com.example.kitchenapp.ui.theme.HotOrange
import com.example.kitchenapp.ui.theme.Malachite
import com.example.kitchenapp.ui.theme.Mirage

sealed class OrderStatusItems(
    val title: String,
    val primaryColor: Color,
    val secondaryColor: Color,
) {
    object NewOrders : OrderStatusItems(
        title = "New Orders",
        primaryColor = DodgerBlue,
        secondaryColor = Mirage
    )

    object Preparing : OrderStatusItems(
        title = "Preparing",
        primaryColor = HotOrange,
        secondaryColor = CoffeeBean
    )

    object Ready : OrderStatusItems(
        title = "Ready",
        primaryColor = Malachite,
        secondaryColor = Aztec
    )
}

val OrderStatusList = listOf(
    OrderStatusItems.NewOrders,
    OrderStatusItems.Preparing,
    OrderStatusItems.Ready

)
