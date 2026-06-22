package com.example.kitchenapp.data.dto

import com.google.firebase.firestore.DocumentId

data class StaffDto(
    @DocumentId
    val id: String = "",
    val department: String = "",
    val imageUrl: String = "",
    val lastClockInTime: Long = 0L,
    val name: String = "",
    val role: String = "",
    val status: String = "",
    val workedHoursInWeek: Double = 0.0,
    val workedHoursToday: Long = 0L
)
