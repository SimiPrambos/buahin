package com.example.buahin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buahin.model.Category
import com.example.buahin.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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