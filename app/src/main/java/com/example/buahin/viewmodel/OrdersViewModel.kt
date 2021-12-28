/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * OrdersViewModel.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buahin.model.Order
import com.example.buahin.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
) : ViewModel() {
    private val _state = mutableStateOf(OrdersState())
    val state: State<OrdersState> = _state

    fun onEvent(event: OrdersEvent) {
        when (event) {
            is OrdersEvent.Load -> {
                viewModelScope.launch {
                    val orders = orderRepository.findAll()
                    _state.value = _state.value.copy(items = orders)
                }
            }
        }
    }

}

data class OrdersState(
    val items: List<Order> = emptyList(),
)

sealed class OrdersEvent {
    object Load : OrdersEvent()
}