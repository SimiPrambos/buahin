/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * CartRepository.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.repository

import android.util.Log
import com.example.buahin.model.Cart
import com.example.buahin.model.Cart.Companion.toCart
import com.example.buahin.model.Cart.Companion.toQty
import com.example.buahin.model.Product
import com.example.buahin.model.Product.Companion.toProduct
import com.google.firebase.firestore.*
import kotlinx.coroutines.tasks.await

class CartRepository(private val uuid: String, private val firestore: FirebaseFirestore) {
    private var listener: ListenerRegistration? = null

    private val ref: CollectionReference
        get() = firestore.collection("users/$uuid/carts")

    suspend fun findAll(): List<Cart> {
        return try {
            toCarts(ref.get().await().documents)
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun remove(id: String) {
        ref.document(id).delete().await()
    }

    suspend fun toCarts(docs: List<DocumentSnapshot>): List<Cart> {
        return docs.mapNotNull {
            val product = it.getDocumentReference("product")!!.get().await().toProduct()
            it.toCart(product)
        }
    }

    fun listen(callback: (List<DocumentSnapshot>) -> Unit) {
        listener = ref.addSnapshotListener { data, e ->
            if (e != null) return@addSnapshotListener
            if (data == null) return@addSnapshotListener
            callback(data.documents)
        }
    }

    fun close() {
        listener?.remove()
    }

    suspend fun changeQyt(id: String, qty: Int) {
        ref.document(id).update("qty", qty).await()
    }

    suspend fun delete(id: String) {
        ref.document(id).delete().await()
    }

    suspend fun createOrUpdate(product: Product, qty: Int) {
        try {
            val productRef = firestore.document(product.ref)
            val carts = ref.whereEqualTo("product", productRef).get().await()
            if (carts.isEmpty) {
                val data = hashMapOf(
                    "product" to productRef,
                    "qty" to qty
                )
                ref.add(data).await()
            } else {
                val cart = carts.documents.first()
                ref.document(cart.id).update("qty", cart.toQty() + qty).await()
            }
        } catch (e: Exception) {
            Log.e("ADD CART", e.toString())
        }
    }
}