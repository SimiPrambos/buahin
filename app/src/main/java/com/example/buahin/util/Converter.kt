package com.example.buahin.util

import java.text.NumberFormat
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
    }
}