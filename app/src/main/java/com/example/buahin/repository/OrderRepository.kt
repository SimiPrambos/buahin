package com.example.buahin.repository

import android.util.Log
import com.example.buahin.model.Address
import com.example.buahin.model.Cart
import com.example.buahin.model.Order
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
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
}