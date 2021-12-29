/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * OrderRepository.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.repository

import android.util.Log
import com.example.buahin.model.Address
import com.example.buahin.model.Cart.Companion.toCart
import com.example.buahin.model.Order
import com.example.buahin.model.Order.Companion.toOrder
import com.example.buahin.model.Product
import com.example.buahin.model.Product.Companion.toProductFromMap
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await
import java.util.*

class OrderRepository(
    private val uuid: String,
    private val firestore: FirebaseFirestore,
    private val cartRepository: CartRepository,
) {
    private val ref: CollectionReference
        get() = firestore.collection("users/$uuid/orders")

    suspend fun create() {
        val carts = cartRepository.findAll()
        val order = Order(
            id = "",
            status = "placed",
            total = carts.fold(0f) { value, cart -> value + cart.subtotal() },
            createdAt = Date(),
            address = Address.default(),
        )
        ref.add(order.toMap()).await().collection("details").let { details ->
            carts.forEach {
                details.add(it.toMap()).await()
                cartRepository.delete(it.id)
            }
        }
    }

    suspend fun findAll(): List<Order> {
        return try {
            ref.orderBy("created_at", Query.Direction.DESCENDING).get()
                .await().documents.mapNotNull {
                    it.toOrder().apply {
                        val detailsRef = ref.document(id).collection("details").get().await()
                        details = detailsRef.documents.mapNotNull { detail ->
                            detail.toCart(detail.toProductFromMap())
                        }
                    }
                }
        } catch (e: Exception) {
            Log.e("ORDERS", e.toString())
            emptyList()
        }
    }
}