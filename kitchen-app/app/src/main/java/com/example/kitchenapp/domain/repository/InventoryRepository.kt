package com.example.kitchenapp.domain.repository

import com.example.kitchenapp.domain.model.InventoryItem
import kotlinx.coroutines.flow.Flow

interface InventoryRepository {

    fun getInventoryItems(): Flow<List<InventoryItem>>
}
