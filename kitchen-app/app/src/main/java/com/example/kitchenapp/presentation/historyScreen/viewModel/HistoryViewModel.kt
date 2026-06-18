package com.example.kitchenapp.presentation.historyScreen.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitchenapp.domain.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: OrderRepository
): ViewModel() {

    private val _state = MutableStateFlow(HistoryState())
    val state: StateFlow<HistoryState> = _state.asStateFlow()


    init {
        fetchCompletedOrders()
    }



    private fun fetchCompletedOrders() {
        viewModelScope.launch {
            repository.getOrders().collect { orderList ->
                _state.update {
                    it.copy(
                        compLastedOrders = orderList
                    )
                }
            }
        }
    }
}