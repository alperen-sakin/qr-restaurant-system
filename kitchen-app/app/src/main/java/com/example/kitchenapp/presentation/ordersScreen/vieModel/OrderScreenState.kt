package com.example.kitchenapp.presentation.ordersScreen.vieModel

import com.example.kitchenapp.domain.model.Order

data class OrderScreenState(
    val orders: List<Order> = emptyList(),
)
