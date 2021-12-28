/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * CartViewModel.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buahin.model.Cart
import com.example.buahin.model.Product
import com.example.buahin.repository.CartRepository
import com.example.buahin.util.Converter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val cartRepository: CartRepository) : ViewModel() {
    private val _state = mutableStateOf(CartState())
    val state: State<CartState> = _state

    init {
        cartRepository.listen {
            viewModelScope.launch {
                _state.value = _state.value.copy(
                    items = cartRepository.toCarts(it)
                )
            }
        }
    }

    override fun onCleared() {
        cartRepository.close()
        super.onCleared()
    }

    fun onEvent(event: CartEvent) {
        when (event) {
            is CartEvent.QtyChanged -> {
                val items = _state.value.items.toMutableList()
                val cart = items[event.index].copy(qty = event.qty)
                items[event.index] = cart
                _state.value = _state.value.copy(items = items)
                viewModelScope.launch {
                    cartRepository.changeQyt(cart.id, event.qty)
                }
            }
            is CartEvent.CartRemoved -> {
                val items = _state.value.items.toMutableList()
                val cart = items.removeAt(event.index)
                _state.value = _state.value.copy(items = items)
                viewModelScope.launch {
                    cartRepository.delete(cart.id)
                }
            }
            is CartEvent.CartAdded -> {
                val items = _state.value.items.toMutableList()
                val index = items.indexOfFirst { it.product.id == event.product.id }
                if (index < 0) {
                    items.add(Cart("", event.product, event.qty))
                } else {
                    items[index] = items[index].copy(qty = event.qty)
                }
                _state.value = _state.value.copy(items = items)
                viewModelScope.launch {
                    cartRepository.createOrUpdate(event.product, event.qty)
                }
            }
        }
    }
}

data class CartState(
    val items: List<Cart> = emptyList(),
) {
    val total: Float
        get() = items.fold(0f) { value, cart -> value + cart.subtotal() }
    val totalIdr: String
        get() = Converter.idr(total)
}

sealed class CartEvent {
    data class QtyChanged(val index: Int, val qty: Int) : CartEvent()
    data class CartRemoved(val index: Int) : CartEvent()
    data class CartAdded(val product: Product, val qty: Int) : CartEvent()
}