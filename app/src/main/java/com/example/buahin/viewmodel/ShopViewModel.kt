package com.example.buahin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buahin.model.Category
import com.example.buahin.model.Product
import com.example.buahin.repository.CategoryRepository
import com.example.buahin.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository,
) : ViewModel() {

    private val _state = mutableStateOf(ShopState())
    val state: State<ShopState> = _state

    fun onEvent(event: ShopEvent) {
        when (event) {
            is ShopEvent.LoadCategory -> {
                viewModelScope.launch {
                    delay(1000)
                    val categories = categoryRepository.findSummary()
                    _state.value = _state.value.copy(
                        categories = categories
                    )
                }
            }
            is ShopEvent.LoadOffer -> {
                viewModelScope.launch {
                    delay(1000)
                    val offers = productRepository.findOffers()
                    _state.value = _state.value.copy(offers = offers)
                }
            }
            is ShopEvent.LoadBestSeller -> {
                viewModelScope.launch {
                    delay(1000)
                    val bestSeller = productRepository.findBestSeller()
                    _state.value = _state.value.copy(bestSeller = bestSeller)
                }
            }
        }
    }
}

data class ShopState(
    val categories: List<Category> = emptyList(),
    val offers: List<Product> = emptyList(),
    val bestSeller: List<Product> = emptyList(),
)

sealed class ShopEvent {
    object LoadCategory : ShopEvent()
    object LoadOffer : ShopEvent()
    object LoadBestSeller : ShopEvent()
}