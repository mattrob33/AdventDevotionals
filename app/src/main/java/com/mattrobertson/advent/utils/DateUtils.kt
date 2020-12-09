package com.mattrobertson.advent.utils

import android.annotation.SuppressLint
import androidx.core.util.Preconditions.checkArgument
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun getTodaysDate(): String = SimpleDateFormat("yyyy-MM-dd").format(Date())

@SuppressLint("SimpleDateFormat")
fun getTodaysDateHumanReadable(): String = SimpleDateFormat("MMMM d, yyyy").format(Date())

fun getDayOfMonthSuffix(n: Int): String? {
    require(n in 1..31 ) { "illegal day of month: $n" }
    return if (n in 11..13) {
        "th"
    } else when (n % 10) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }
}