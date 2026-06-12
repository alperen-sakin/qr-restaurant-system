package com.example.kitchenapp.presentation.ordersScreen.constants

import com.example.kitchenapp.domain.model.Order
import com.example.kitchenapp.domain.model.OrderItem

val DummyData = listOf<Order>(
    Order(
        id = 1,
        tableNumber = "1",
        date = "20:00",
        status = "New",
        orderItems = listOf<OrderItem>(OrderItem("Pizza", 2)),
        totalCost = 20.0
    ),
    Order(
        id = 2,
        tableNumber = "5",
        date = "30:00",
        status = "Preparing",
        orderItems = listOf<OrderItem>(OrderItem("kola", 1), OrderItem("Burger", 3)),
        totalCost = 10.0
    ),
    Order(
        id = 3,
        tableNumber = "10",
        date = "10:00",
        status = "Ready",
        orderItems = listOf<OrderItem>(
            OrderItem("Mama", 1),
            OrderItem("Burger", 2),
            OrderItem("Pizza", 3)
        ),
        totalCost = 10.0
    ),

)

