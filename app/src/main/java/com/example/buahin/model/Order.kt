package com.example.buahin.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentSnapshot
import java.util.*
import kotlin.collections.HashMap

data class Order(
    val id: String,
    val createdAt: Date,
    val status: String,
    val total: Float,
    val address: Address,
) {
    companion object {
        fun DocumentSnapshot.toOrder(): Order {
            return Order(
                id = id,
                createdAt = getDate("created_at")!!,
                status = getString("status")!!,
                total = getDouble("total")!!.toFloat(),
                address = Address(
                    name = getString("address.name")!!,
                    phone = getString("address.phone")!!,
                    province = getString("address.province")!!,
                    city = getString("address.city")!!,
                    district = getString("address.district")!!,
                    code = getString("address.code")!!,
                    detail = getString("address.detail")!!,
                )
            )
        }
    }

    fun toMap() : HashMap<String, Any> {
        return hashMapOf(
            "created_at" to Timestamp(createdAt),
            "status" to status,
            "total" to total,
            "address" to address.toMap(),
        )
    }
}