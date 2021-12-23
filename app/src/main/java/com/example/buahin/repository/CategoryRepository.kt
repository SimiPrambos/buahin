package com.example.buahin.repository

import com.example.buahin.model.Category

class CategoryRepository {
    fun findSummary() : List<Category> {
        return listOf(
            Category("1", "Fruits", ""),
            Category("2", "Vegetables", ""),
            Category("3", "Meat & Fish", ""),
        )
    }
}