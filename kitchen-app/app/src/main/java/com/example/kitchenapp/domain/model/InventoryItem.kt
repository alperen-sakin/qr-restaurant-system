package com.example.kitchenapp.domain.model

data class InventoryItem(
    val itemName: String,
    val quantity: Int,
    val unit: String,
    val imgUrl: String,
    val itemNumber: Int,
    val minStockLevel: Int
)
