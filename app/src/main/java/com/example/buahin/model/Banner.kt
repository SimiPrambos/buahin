/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * BannerSlider.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.model

import com.google.firebase.firestore.DocumentSnapshot

data class Banner(
    val id: String,
    val thumbnail: String,
) {
    companion object {
        fun DocumentSnapshot.toBanner(): Banner {
            return Banner(
                id = id,
                thumbnail = getString("thumbnail")!!,
            )
        }
    }
}
