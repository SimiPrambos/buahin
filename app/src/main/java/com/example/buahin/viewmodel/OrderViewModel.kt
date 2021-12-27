package com.example.buahin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buahin.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
) : ViewModel() {
    private val _state = mutableStateOf<OrderState>(OrderState.Loading)
    val state: State<OrderState> = _state

    fun onEvent(event: OrderEvent) {
        when (event) {
            is OrderEvent.Requested -> {
                viewModelScope.launch {
                    try {
                        orderRepository.create()
                        delay(5000)
                        _state.value = OrderState.Success
                    } catch (e: Exception) {
                        _state.value = OrderState.Failed
                    }
                }
            }
        }
    }
}

sealed class OrderState {
    object Loading : OrderState()
    object Success : OrderState()
    object Failed : OrderState()
}

sealed class OrderEvent {
    object Requested : OrderEvent()
}