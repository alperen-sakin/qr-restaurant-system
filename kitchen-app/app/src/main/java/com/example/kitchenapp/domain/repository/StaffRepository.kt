package com.example.kitchenapp.domain.repository

import com.example.kitchenapp.domain.model.Staff
import kotlinx.coroutines.flow.Flow

interface StaffRepository {

    fun getStaff(): Flow<List<Staff>>

    suspend fun updateStaffStatus(staffId: String, newStatus: String, clockInTime: Long)

    suspend fun updateStaffBreak(staffId: String, newStatus: String, workedHoursToday: Long)

    suspend fun updateStaffEnd(staffId: String, newStatus: String, workedHoursToday: Long)
}
