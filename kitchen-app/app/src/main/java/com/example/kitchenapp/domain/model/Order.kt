package com.example.kitchenapp.domain.model

data class Order(
    val id: String,
    val tableNumber: String,
    val status: String,
    val orderItems: List<OrderItem>,
    val totalCost: Double,
    val date: String

)
