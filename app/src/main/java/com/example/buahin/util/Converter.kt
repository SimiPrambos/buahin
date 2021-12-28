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