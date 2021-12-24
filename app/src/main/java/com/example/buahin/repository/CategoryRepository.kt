package com.example.buahin.repository

import com.example.buahin.model.Category
import com.example.buahin.model.Category.Companion.toCategory
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class CategoryRepository(private val firestore: FirebaseFirestore) {
    suspend fun findSummary(): List<Category> {
        return try {
            firestore.collection("categories").limit(3).get()
                .await().documents.mapNotNull { it.toCategory() }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun findAll(): List<Category> {
        return try {
            firestore.collection("categories").get()
                .await().documents.mapNotNull { it.toCategory() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}