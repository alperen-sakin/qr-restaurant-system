package com.example.kitchenapp.data.dto

data class InventoryItemDto(
    val itemName: String = "",
    val quantity: Int = 0,
    val unit: String = "",
    val imgUrl: String = "",
    val itemNumber: Int = 0,
    val minStockLevel: Int = 0
)
