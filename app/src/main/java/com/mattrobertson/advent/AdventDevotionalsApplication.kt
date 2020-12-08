package com.mattrobertson.advent

import android.app.Application
import android.content.Context

class AdventDevotionalsApplication: Application() {

	companion object {
		lateinit var context: Context
			private set
	}

	override fun onCreate() {
		super.onCreate()
		context = this
	}
}