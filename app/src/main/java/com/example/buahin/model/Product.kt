package com.example.buahin.model

import com.google.firebase.firestore.DocumentSnapshot

data class Product(
    val id: String,
    val name: String,
    val summary: String,
    val price: Float,
    val thumbnail: String,
    val description: String? = null,
    val nutrition: String? = null,
    val howToSave: String? = null,
    val ref: String,
) {
    companion object {
        fun DocumentSnapshot.toProduct(): Product {
            return Product(
                id = id,
                name = getString("name")!!,
                summary = getString("summary")!!,
                price = getDouble("price")!!.toFloat(),
                thumbnail = getString("thumbnail")!!,
                description = getString("description"),
                nutrition = getString("nutrition"),
                howToSave = getString("how_to_save"),
                ref = reference.path,
            )
        }
    }
}
