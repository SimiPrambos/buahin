/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * CategoryRepository.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

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