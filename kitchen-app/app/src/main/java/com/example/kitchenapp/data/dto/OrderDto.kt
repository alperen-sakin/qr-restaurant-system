package com.example.kitchenapp.data.dto

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class OrderDto(
    @DocumentId
    val id: String = "",
    val tableNumber: String = "",
    val status: String = "",
    val items: List<OrderItemDto> = emptyList(),
    val total: Double = 0.0,
    val createdAt: Timestamp? = null
)
