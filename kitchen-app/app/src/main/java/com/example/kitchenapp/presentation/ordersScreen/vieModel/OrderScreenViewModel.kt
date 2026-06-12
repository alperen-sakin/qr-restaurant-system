package com.example.kitchenapp.presentation.ordersScreen.vieModel

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
class OrderScreenViewModel @Inject constructor(
    private val repository: OrderRepository
) : ViewModel() {

    private val _state = MutableStateFlow(OrderScreenState())
    val state: StateFlow<OrderScreenState> = _state.asStateFlow()

    init {
        fetchOrders()
    }

    private fun fetchOrders() {
        viewModelScope.launch {
            repository.getOrders().collect { orderList ->
                _state.update {
                    it.copy(
                        orders = orderList
                    )
                }
                Log.d("deneme", "denem: ${state.value.orders}")
            }
        }
    }


}
