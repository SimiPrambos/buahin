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
}