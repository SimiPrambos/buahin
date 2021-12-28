/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * Address.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.model

data class Address(
    val name: String,
    val phone: String,
    val province: String,
    val city: String,
    val district: String,
    val code: String,
    val detail: String,
) {
    fun toMap() : HashMap<String, String> {
        return hashMapOf(
            "name" to name,
            "phone" to phone,
            "province" to province,
            "city" to city,
            "district" to district,
            "code" to code,
            "detail" to detail,
        )
    }

    companion object {
        fun default() : Address {
            return Address(
                name = "Simi Prambos",
                phone = "085870853528",
                province = "Jawa Tengah",
                city = "Kudus",
                district = "Bae",
                code = "59158",
                detail = "Jl Gondang manis Gg.15 RT 01 RW 02"
            )
        }
    }
}
