package com.example.buahin.repository

import com.example.buahin.model.Category
import com.example.buahin.model.Product

class ProductRepository {
    fun findOffers(): List<Product> {
        return listOf(
            Product(
                id = "1",
                name = "Banana",
                summary = "7pcs, Price",
                description = "this is description",
                thumbnail = "",
                price = 14500F,
                category = Category(
                    id = "1",
                    name = "Fruit",
                    thumbnail = ""
                )
            ),
            Product(
                id = "1",
                name = "Banana",
                summary = "7pcs, Price",
                description = "this is description",
                thumbnail = "",
                price = 14500F,
                category = Category(
                    id = "1",
                    name = "Fruit",
                    thumbnail = ""
                )
            ),
            Product(
                id = "1",
                name = "Banana",
                summary = "7pcs, Price",
                description = "this is description",
                thumbnail = "",
                price = 14500F,
                category = Category(
                    id = "1",
                    name = "Fruit",
                    thumbnail = ""
                )
            ),
        )
    }

    fun findBestSeller(): List<Product> {
        return listOf(
            Product(
                id = "1",
                name = "Banana",
                summary = "7pcs, Price",
                description = "this is description",
                thumbnail = "",
                price = 14500F,
                category = Category(
                    id = "1",
                    name = "Fruit",
                    thumbnail = ""
                )
            ),
            Product(
                id = "1",
                name = "Banana",
                summary = "7pcs, Price",
                description = "this is description",
                thumbnail = "",
                price = 14500F,
                category = Category(
                    id = "1",
                    name = "Fruit",
                    thumbnail = ""
                )
            ),
            Product(
                id = "1",
                name = "Banana",
                summary = "7pcs, Price",
                description = "this is description",
                thumbnail = "",
                price = 14500F,
                category = Category(
                    id = "1",
                    name = "Fruit",
                    thumbnail = ""
                )
            ),
        )
    }
}