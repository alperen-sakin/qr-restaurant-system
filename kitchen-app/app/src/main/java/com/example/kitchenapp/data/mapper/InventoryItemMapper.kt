package com.example.kitchenapp.data.mapper

import com.example.kitchenapp.data.dto.InventoryItemDto
import com.example.kitchenapp.domain.model.InventoryItem

fun InventoryItemDto.toDomain(): InventoryItem {
    return InventoryItem(
        itemName = itemName,
        quantity = quantity,
        unit = unit,
        imgUrl = imgUrl,
        itemNumber = itemNumber,
        minStockLevel = minStockLevel
    )
}

fun InventoryItem.toDto(): InventoryItemDto {
    return InventoryItemDto(
        itemName = itemName,
        quantity = quantity,
        unit = unit,
        imgUrl = imgUrl,
        itemNumber = itemNumber,
        minStockLevel = minStockLevel
    )
}
