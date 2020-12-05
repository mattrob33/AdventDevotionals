package com.mattrobertson.advent

import android.app.Application
import android.content.Context

class AdventDevotionalsApplication: Application() {

	companion object {
		lateinit var applicationContext: Context
			private set
	}

	override fun onCreate() {
		super.onCreate()
		AdventDevotionalsApplication.applicationContext = this
	}
}