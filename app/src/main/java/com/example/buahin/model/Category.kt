package com.example.buahin.model

import com.google.firebase.firestore.DocumentSnapshot

data class Category(
    val id: String,
    val name: String,
    val thumbnail: String,
) {
    companion object {
        fun DocumentSnapshot.toCategory(): Category {
            return Category(
                id = id,
                name = getString("name")!!,
                thumbnail = getString("thumbnail")!!,
            )
        }
    }
}
