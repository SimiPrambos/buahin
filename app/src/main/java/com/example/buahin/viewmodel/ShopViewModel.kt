/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * ShopViewModel.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buahin.model.Banner
import com.example.buahin.model.Category
import com.example.buahin.model.Product
import com.example.buahin.repository.BannerRepository
import com.example.buahin.repository.CategoryRepository
import com.example.buahin.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository,
    private val bannerRepository: BannerRepository,
) : ViewModel() {

    private val _state = mutableStateOf(ShopState())
    val state: State<ShopState> = _state

    fun onEvent(event: ShopEvent) {
        when (event) {
            is ShopEvent.LoadBanner -> {
                viewModelScope.launch {
                    val banners = bannerRepository.findAll()
                    _state.value = _state.value.copy(
                        banners = banners
                    )
                }
            }
            is ShopEvent.LoadCategory -> {
                viewModelScope.launch {
                    val categories = categoryRepository.findSummary()
                    _state.value = _state.value.copy(
                        categories = categories
                    )
                }
            }
            is ShopEvent.LoadOffer -> {
                viewModelScope.launch {
                    val offers = productRepository.findOffers()
                    _state.value = _state.value.copy(offers = offers)
                }
            }
            is ShopEvent.LoadBestSeller -> {
                viewModelScope.launch {
                    val bestSeller = productRepository.findBestSeller()
                    _state.value = _state.value.copy(bestSeller = bestSeller)
                }
            }
        }
    }
}

data class ShopState(
    val banners: List<Banner> = emptyList(),
    val categories: List<Category> = emptyList(),
    val offers: List<Product> = emptyList(),
    val bestSeller: List<Product> = emptyList(),
)

sealed class ShopEvent {
    object LoadBanner : ShopEvent()
    object LoadCategory : ShopEvent()
    object LoadOffer : ShopEvent()
    object LoadBestSeller : ShopEvent()
}