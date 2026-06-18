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
