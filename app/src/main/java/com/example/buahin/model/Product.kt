package com.example.buahin.model

data class Product(
    val id: String,
    val name: String,
    val summary: String,
    val description: String,
    val thumbnail: String,
    val category: Category,
    val price: Float,
)
