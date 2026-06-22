package com.example.kitchenapp.domain.model

data class Staff(
    val id: String,
    val department: String,
    val imageUrl: String,
    val lastClockInTime: Long,
    val name: String,
    val role: String,
    val status: String,
    val workedHoursInWeek: Double,
    val workedHoursToday: Long
)
