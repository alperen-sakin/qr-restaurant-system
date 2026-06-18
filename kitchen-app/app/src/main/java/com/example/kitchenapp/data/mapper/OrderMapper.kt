package com.example.kitchenapp.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.kitchenapp.data.dto.OrderDto
import com.example.kitchenapp.data.dto.OrderItemDto
import com.example.kitchenapp.domain.model.Order
import com.example.kitchenapp.domain.model.OrderItem
import com.google.firebase.Timestamp

const val ORDER_NUMBER_LENGTH = 4

@RequiresApi(Build.VERSION_CODES.O)
fun OrderDto.toDomain(): Order {
    val timeInMillis = createdAt?.toDate()?.time ?: System.currentTimeMillis()
    return Order(
        id = id,
        tableNumber = tableNumber,
        status = status,
        orderItems = items.map { it.toDomain() },
        totalCost = total,
        date = timeInMillis,
        orderNumber = orderNumber
    )
}

fun OrderItemDto.toDomain(): OrderItem {
    return OrderItem(
        name = name,
        quantity = quantity
    )
}

fun Order.toDto(): OrderDto {
    return OrderDto(
        id = id,
        tableNumber = tableNumber,
        status = status,
        items = orderItems.map { it.toDto() },
        total = totalCost,
        createdAt = Timestamp.now()
    )
}

fun OrderItem.toDto(): OrderItemDto {
    return OrderItemDto(
        name = name,
        quantity = quantity
    )
}
