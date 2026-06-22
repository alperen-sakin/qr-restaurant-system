package com.example.kitchenapp.presentation.staffScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitchenapp.domain.repository.StaffRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StaffViewModel @Inject constructor(
    private val staffRepository: StaffRepository

) : ViewModel() {

    private val _state = MutableStateFlow(StaffScreenState())
    val state: StateFlow<StaffScreenState> = _state.asStateFlow()

    init {
        fetchStaff()
    }

    fun fetchStaff() {
        viewModelScope.launch {
            staffRepository.getStaff().collect { staffList ->
                _state.update {
                    it.copy(
                        staffs = staffList
                    )
                }
            }
        }
    }

    fun onStartClicked(staffId: String) {
        viewModelScope.launch {
            staffRepository.updateStaffStatus(
                staffId = staffId,
                newStatus = "working",
                clockInTime = System.currentTimeMillis()

            )
        }
    }

    fun onBreakClicked(staffId: String) {
        val staff = _state.value.staffs.find { it.id == staffId } ?: return

        val currentTime = System.currentTimeMillis()

        val elapsedMillis = currentTime - staff.lastClockInTime

        val updatedWorkedHoursToday = staff.workedHoursToday + elapsedMillis

        viewModelScope.launch {
            staffRepository.updateStaffBreak(
                staffId = staffId,
                newStatus = "on_break",
                workedHoursToday = updatedWorkedHoursToday
            )
        }
    }

    fun onEndClicked(staffId: String) {
        val staff = _state.value.staffs.find { it.id == staffId } ?: return

        // 1. O anki duruma göre süreyi hesapla
        val updatedWorkedHoursToday = if (staff.status.lowercase() == "working") {
            val currentTime = System.currentTimeMillis()
            val elapsedMillis = currentTime - staff.lastClockInTime
            staff.workedHoursToday + elapsedMillis
        } else {
            // Zaten moladaysa, mola tuşuna basıldığında süre hesaba katılmıştı
            staff.workedHoursToday
        }

        viewModelScope.launch {
            staffRepository.updateStaffEnd(
                staffId = staffId,
                newStatus = "off_duty", // Mesai dışı durumu
                workedHoursToday = updatedWorkedHoursToday
            )
        }
    }
}
