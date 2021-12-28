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
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ProductRepository(private val firestore: FirebaseFirestore) {
    suspend fun findOffers(): List<Product> {
        return try {
            firestore.collectionGroup("products").whereEqualTo("is_offer", true)
                .limit(5).get()
                .await().documents.mapNotNull { it.toProduct() }
        } catch (e: Exception) {
            Log.println(Log.ERROR, "PRODUCT", e.toString())
            emptyList()
        }
    }

    suspend fun findBestSeller(): List<Product> {
        return try {
            firestore.collectionGroup("products").whereEqualTo("is_best_seller", true)
                .limit(5).get()
                .await().documents.mapNotNull { it.toProduct() }
        } catch (e: Exception) {
            Log.println(Log.ERROR, "PRODUCT", e.toString())
            emptyList()
        }
    }

    suspend fun findOne(id: String): Product? {
        return try {
            firestore.collectionGroup("products")
                .whereEqualTo("id", id).get()
                .await().documents.firstNotNullOfOrNull { it.toProduct() }
        } catch (e: Exception) {
            Log.println(Log.ERROR, "PRODUCT", e.toString())
            null
        }
    }

    suspend fun findByCategory(category: String): List<Product> {
        return try {
            firestore.collection("categories/$category/products").get()
                .await().documents.mapNotNull { it.toProduct() }
        } catch (e: Exception) {
            Log.println(Log.ERROR, "PRODUCT", e.toString())
            emptyList()
        }
    }
}