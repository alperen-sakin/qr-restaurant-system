package com.example.kitchenapp.domain.repository

import com.example.kitchenapp.domain.model.Order
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    fun getOrders(): Flow<List<Order>>
}
