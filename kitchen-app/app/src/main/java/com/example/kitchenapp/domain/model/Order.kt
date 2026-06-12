package com.example.kitchenapp.domain.model

data class Order(
    val id: Int,
    val tableNumber: String,
    val status: String,
    val orderItems: List<OrderItem>,
    val totalCost: Double,
    val date: String

)
