package com.example.kitchenapp.presentation.staffScreen.viewModel

import com.example.kitchenapp.domain.model.Staff

data class StaffScreenState(
    val staffs: List<Staff> = emptyList(),
)
