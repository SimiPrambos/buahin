/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * Converter.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.util

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class Converter {
    companion object {
        fun idr(number: Float): String {
            val localeID = Locale("in", "ID")
            val numberFormat = NumberFormat.getCurrencyInstance(localeID).apply {
                maximumFractionDigits = 0
            }
            return numberFormat.format(number).toString()
        }

        fun humanize(date: Date) : String {
            val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm")
            return formatter.format(date)
        }
    }
}