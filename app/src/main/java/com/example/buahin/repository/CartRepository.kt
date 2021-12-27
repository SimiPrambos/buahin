package com.example.buahin.repository

import android.util.Log
import com.example.buahin.model.Cart
import com.example.buahin.model.Cart.Companion.toCart
import com.example.buahin.model.Cart.Companion.toQty
import com.example.buahin.model.Product
import com.example.buahin.model.Product.Companion.toProduct
import com.google.firebase.firestore.*
import kotlinx.coroutines.tasks.await

class CartRepository(private val firestore: FirebaseFirestore) {
    private var listener: ListenerRegistration? = null

    private fun ref(uuid: String): CollectionReference {
        return firestore.collection("users/$uuid/carts")
    }

    suspend fun toCarts(docs: List<DocumentSnapshot>): List<Cart> {
        return docs.mapNotNull {
            val product = it.getDocumentReference("product")!!.get().await().toProduct()
            it.toCart(product)
        }
    }

    fun listen(uuid: String, callback: (List<DocumentSnapshot>) -> Unit) {
        listener = ref(uuid).addSnapshotListener { data, e ->
            if (e != null) return@addSnapshotListener
            if (data == null) return@addSnapshotListener
            callback(data.documents)
        }
    }

    fun close() {
        listener?.remove()
    }

    suspend fun changeQyt(uuid: String, id: String, qty: Int) {
        ref(uuid).document(id).update("qty", qty).await()
    }

    suspend fun delete(uuid: String, id: String) {
        ref(uuid).document(id).delete().await()
    }

    suspend fun createOrUpdate(uuid: String, product: Product, qty: Int) {
        try {
            val productRef = firestore.document(product.ref)
            val carts = ref(uuid).whereEqualTo("product", productRef).get().await()
            if (carts.isEmpty) {
                val data = hashMapOf(
                    "product" to productRef,
                    "qty" to qty
                )
                ref(uuid).add(data).await()
            } else {
                val cart = carts.documents.first()
                ref(uuid).document(cart.id).update("qty", cart.toQty() + qty).await()
            }
        } catch (e: Exception) {
            Log.e("ADD CART", e.toString())
        }
    }
}