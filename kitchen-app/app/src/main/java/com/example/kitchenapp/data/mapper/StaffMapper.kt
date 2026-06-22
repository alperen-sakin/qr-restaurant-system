package com.example.kitchenapp.data.mapper

import com.example.kitchenapp.data.dto.StaffDto
import com.example.kitchenapp.domain.model.Staff

fun StaffDto.toDomain(): Staff {
    return Staff(
        id = id,
        department = department,
        imageUrl = imageUrl,
        lasClockInTime = lasClockInTime,
        name = name,
        role = role,
        status = status,
        workedHoursInWeek = workedHoursInWeek,
        workedHoursToday = workedHoursToday

    )
}

fun Staff.toDto(): StaffDto {
    return StaffDto(
        id = id,
        department = department,
        imageUrl = imageUrl,
        lasClockInTime = lasClockInTime,
        name = name,
        role = role,
        status = status,
        workedHoursInWeek = workedHoursInWeek,
        workedHoursToday = workedHoursToday
    )
}
