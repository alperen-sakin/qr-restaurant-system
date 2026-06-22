package com.example.kitchenapp.presentation.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toFormattedTime(): String {
    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    return formatter.format(Date(this))
}

fun Long.toFormattedDate(): String {
    val formatter = SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.getDefault())
    return formatter.format(Date(this))
}

private const val MILLISECOND = 1000

private const val SECOND = 3600

private const val MUNIT = 60

fun Long.toFormattedDuration(): String {
    val totalSeconds = this / MILLISECOND
    val hours = totalSeconds / SECOND
    val minutes = (totalSeconds % SECOND) / MUNIT
    return String.format(Locale.US, "%02d:%02d", hours, minutes)
}
