package com.example.buahin.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.userProfileChangeRequest
import kotlinx.coroutines.tasks.await

class AuthRepository(private val fireauth: FirebaseAuth) {
    fun currentUser(): FirebaseUser? {
        return fireauth.currentUser
    }

    suspend fun signIn(email: String, password: String): FirebaseUser? {
        return try {
            fireauth.signInWithEmailAndPassword(email, password).await().user
        } catch (e: Exception) {
            Log.e("SIGN IN", e.toString())
            null
        }
    }

    fun signOut() {
        fireauth.signOut()
    }

    suspend fun signUp(name: String, email: String, password: String) {
        try {
            fireauth.createUserWithEmailAndPassword(email, password).await().let {
                val profile = userProfileChangeRequest {
                    displayName = name
                }
                it.user?.updateProfile(profile)?.await()
            }
        } catch (e: Exception) {
            Log.e("EMAIL", email)
            Log.e("NAME", name)
            Log.e("PASSWORD", password)
            Log.e("SIGN UP", e.toString())
        }
    }

    fun addListener(listener: (FirebaseAuth) -> Unit) {
        fireauth.addAuthStateListener(listener)
    }

    fun removeListener(listener: (FirebaseAuth) -> Unit) {
        fireauth.removeAuthStateListener(listener)
    }
}