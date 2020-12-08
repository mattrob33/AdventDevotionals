package com.mattrobertson.advent.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun getTodaysDate(): String = SimpleDateFormat("yyyy-MM-dd").format(Date())