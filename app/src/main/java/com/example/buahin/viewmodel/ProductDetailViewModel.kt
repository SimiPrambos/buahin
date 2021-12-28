/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * ProductDetailViewModel.kt
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
import com.example.buahin.ui.screens.args.ProductDetailRouteArgsFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val args = ProductDetailRouteArgsFactory.fromSavedStateHandle(savedStateHandle)
    private val _state = mutableStateOf<ProductDetailState>(ProductDetailState.Loading)
    val state: State<ProductDetailState> = _state

    fun onEvent(event: ProductDetailEvent) {
        when (event) {
            is ProductDetailEvent.Load -> {
                viewModelScope.launch {
                    val product = productRepository.findOne(args.id)
                    if (product == null) {
                        _state.value = ProductDetailState.Empty
                    } else {
                        _state.value = ProductDetailState.Success(product)
                    }
                }
            }
        }
    }
}

sealed class ProductDetailState {
    object Loading : ProductDetailState()
    object Empty : ProductDetailState()
    data class Success(val value: Product) : ProductDetailState()
}

sealed class ProductDetailEvent {
    object Load : ProductDetailEvent()
}