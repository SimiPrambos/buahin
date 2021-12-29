/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * BannerRepository.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.repository

import android.util.Log
import com.example.buahin.model.Banner
import com.example.buahin.model.Banner.Companion.toBanner
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class BannerRepository(private val firestore: FirebaseFirestore) {
    suspend fun findAll(): List<Banner> {
        return try {
            firestore.collection("banners").get().await().documents.mapNotNull { it.toBanner() }
        } catch (e: Exception) {
            Log.e("BANNER REPOSITORY", e.toString())
            emptyList()
        }
    }
}