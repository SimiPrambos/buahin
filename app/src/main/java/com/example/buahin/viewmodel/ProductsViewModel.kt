/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * ProductsViewModel.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buahin.model.Product
import com.example.buahin.repository.ProductRepository
import com.example.buahin.ui.screens.args.ProductsRouteArgsFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val args = ProductsRouteArgsFactory.fromSavedStateHandle(savedStateHandle)
    private val _state = mutableStateOf(ProductsState(args.name))
    val state: State<ProductsState> = _state

    fun onEvent(event: ProductsEvent) {
        when (event) {
            is ProductsEvent.Load -> {
                viewModelScope.launch {
                    val products = productRepository.findByCategory(args.id)
                    _state.value = _state.value.copy(items = products)
                }
            }
        }
    }
}

data class ProductsState(
    val title: String,
    val items: List<Product> = emptyList(),
)

sealed class ProductsEvent {
    object Load : ProductsEvent()
}