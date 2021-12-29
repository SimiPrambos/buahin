/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * ProductRepository.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.repository

import android.util.Log
import com.example.buahin.model.Product
import com.example.buahin.model.Product.Companion.toProduct
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ProductRepository(private val firestore: FirebaseFirestore) {
    private val ref: CollectionReference
        get() = firestore.collection("products")

    suspend fun findOffers(): List<Product> {
        return try {
            ref.whereEqualTo("is_offer", true)
                .limit(5).get()
                .await().documents.mapNotNull { it.toProduct() }
        } catch (e: Exception) {
            Log.println(Log.ERROR, "PRODUCT", e.toString())
            emptyList()
        }
    }

    suspend fun findBestSeller(): List<Product> {
        return try {
            ref.whereEqualTo("is_best_seller", true)
                .limit(5).get()
                .await().documents.mapNotNull { it.toProduct() }
        } catch (e: Exception) {
            Log.println(Log.ERROR, "PRODUCT", e.toString())
            emptyList()
        }
    }

    suspend fun findOne(id: String): Product? {
        Log.e("PRODUCT", id)
        return try {
            val doc = ref.document(id).get().await()
            if (doc.exists()) doc.toProduct() else null
        } catch (e: Exception) {
            Log.e("PRODUCT", e.toString())
            null
        }
    }

    suspend fun findByCategory(categoryId: String): List<Product> {
        return try {
            ref.whereEqualTo("category_id", categoryId)
                .get()
                .await().documents.mapNotNull { it.toProduct() }
        } catch (e: Exception) {
            Log.println(Log.ERROR, "PRODUCT", e.toString())
            emptyList()
        }
    }
}