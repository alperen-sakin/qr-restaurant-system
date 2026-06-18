package com.example.kitchenapp.presentation.inventoryScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitchenapp.domain.repository.InventoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor(
    private val repository: InventoryRepository
) : ViewModel() {

    private val _state = MutableStateFlow(InventoryState())
    val state: StateFlow<InventoryState> = _state.asStateFlow()

    init {
        fetchInventoryItems()
    }

    fun onSearchValueChange(value: String) {
        _state.value = _state.value.copy(
            searchValue = value
        )
    }

    private fun fetchInventoryItems() {
        viewModelScope.launch {
            repository.getInventoryItems().collect { inventoryItems ->
                _state.update {
                    it.copy(
                        inventoryItems = inventoryItems
                    )
                }
            }
        }
    }
}
