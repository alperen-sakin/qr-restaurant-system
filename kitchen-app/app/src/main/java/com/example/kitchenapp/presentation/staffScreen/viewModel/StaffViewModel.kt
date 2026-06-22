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
}
