package com.example.kitchenapp.data.dto

data class StaffDto(
    val id: String = "",
    val department: String = "",
    val imageUrl: String = "",
    val lasClockInTime: Double = 0.0,
    val name: String = "",
    val role: String = "",
    val status: String = "",
    val workedHoursInWeek: Double = 0.0,
    val workedHoursToday: Long = 0
)
