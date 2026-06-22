package com.example.kitchenapp.domain.repository

import com.example.kitchenapp.domain.model.Staff
import kotlinx.coroutines.flow.Flow

interface StaffRepository {

    fun getStaff(): Flow<List<Staff>>

    suspend fun updateStaffStatus(staffId: String, newStatus: String)
}
