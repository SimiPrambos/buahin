/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * ExploreViewModel.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buahin.model.Category
import com.example.buahin.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository,
) : ViewModel() {
    private val _state = mutableStateOf(ExploreState())
    val state : State<ExploreState> = _state

    fun onEvent(event: ExploreEvent) {
        when (event) {
            is ExploreEvent.Load -> {
                viewModelScope.launch {
                    delay(1000)
                    val categories = categoryRepository.findAll()
                    _state.value = _state.value.copy(categories = categories)
                }
            }
        }
    }
}

data class ExploreState(
    val categories: List<Category> = emptyList(),
)

sealed class ExploreEvent {
    object Load : ExploreEvent()
}