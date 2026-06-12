package com.example.kitchenapp.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.kitchenapp.data.dto.OrderDto
import com.example.kitchenapp.data.dto.OrderItemDto
import com.example.kitchenapp.domain.model.Order
import com.example.kitchenapp.domain.model.OrderItem
import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale.getDefault

const val ORDER_NUMBER_LENGTH = 4

@RequiresApi(Build.VERSION_CODES.O)
fun OrderDto.toDomain(): Order {
    val formatter = SimpleDateFormat("HH:mm", getDefault())
    val formattedDate = createdAt?.toDate()?.let { date ->
        formatter.format(date)
    } ?: ""
    val displayOrderNumber = id.takeLast(ORDER_NUMBER_LENGTH).uppercase(getDefault())
    return Order(
        id = displayOrderNumber,
        tableNumber = tableNumber,
        status = status,
        orderItems = items.map { it.toDomain() },
        totalCost = total,
        date = formattedDate,
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
