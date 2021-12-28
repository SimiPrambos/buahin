/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * AuthViewModel.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buahin.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {
    private val _state = mutableStateOf(AuthState())
    val state: State<AuthState> = _state

    init {
        authRepository.addListener(::onAuthStateChanged)
    }

    override fun onCleared() {
        authRepository.removeListener(::onAuthStateChanged)
        super.onCleared()
    }

    private fun onAuthStateChanged(auth: FirebaseAuth) {
        _state.value = _state.value.copy(user = auth.currentUser)
    }

    suspend fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.SignIn -> {
                viewModelScope.launch {
                    authRepository.signIn(event.email, event.password)
                }
            }
            is AuthEvent.SignOut -> {
                viewModelScope.launch {
                    authRepository.signOut()
                }
            }
            is AuthEvent.SignUp -> {
                viewModelScope.launch {
                    authRepository.signUp(
                        name = event.name,
                        email = event.email,
                        password = event.password,
                    )
                }
            }
        }
    }
}

data class AuthState(
    val user: FirebaseUser? = null,
) {
    fun isAuthenticated(): Boolean {
        return user != null;
    }
}

sealed class AuthEvent {
    data class SignIn(val email: String, val password: String) : AuthEvent()
    object SignOut : AuthEvent()
    data class SignUp(val name: String, val email: String, val password: String) : AuthEvent()
}