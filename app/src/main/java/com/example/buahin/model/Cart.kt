package com.example.buahin.model

import com.example.buahin.util.Converter
import com.google.firebase.firestore.DocumentSnapshot

data class Cart(
    val id: String,
    val product: Product,
    val qty: Int,
) {
    fun subtotal(): Float {
        return product.price * qty
    }

    fun subtotalIdr(): String {
        return Converter.idr(subtotal())
    }

    companion object {
        fun DocumentSnapshot.toCart(product: Product): Cart {
            return Cart(
                id = id,
                product = product,
                qty = toQty(),
            )
        }

        fun DocumentSnapshot.toQty(): Int {
            return getLong("qty")!!.toInt()
        }
    }
}
