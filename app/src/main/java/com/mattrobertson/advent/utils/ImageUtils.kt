package com.mattrobertson.advent.utils

import com.mattrobertson.advent.R

fun getImageResId(imageResource: String): Int = when(imageResource) {
	"gallery_add" -> R.drawable.add
	else -> throw IllegalArgumentException("Invalid image resource")
}