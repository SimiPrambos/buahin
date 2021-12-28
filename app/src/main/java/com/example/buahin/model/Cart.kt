/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * Cart.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

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

    fun toMap(): HashMap<String, Any> {
        return hashMapOf(
            "qty" to qty,
            "product" to product.toMap(),
        )
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
