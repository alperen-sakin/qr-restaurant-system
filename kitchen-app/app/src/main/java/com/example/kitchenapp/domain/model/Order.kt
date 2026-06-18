package com.example.kitchenapp.domain.model

data class Order(
    val id: String,
    val orderNumber: Int,
    val tableNumber: String,
    val status: String,
    val orderItems: List<OrderItem>,
    val totalCost: Double,
    val date: Long

)
