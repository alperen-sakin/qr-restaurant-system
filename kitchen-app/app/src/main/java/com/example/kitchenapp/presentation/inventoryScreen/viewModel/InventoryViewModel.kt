package com.example.kitchenapp.presentation.inventoryScreen.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(InventoryState())
    val state: StateFlow<InventoryState> = _state.asStateFlow()

    fun onSearchValueChange(value: String) {
        _state.value = _state.value.copy(
            searchValue = value
        )
    }
}
