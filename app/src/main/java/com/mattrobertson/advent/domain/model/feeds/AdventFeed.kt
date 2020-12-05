package com.mattrobertson.advent.domain.model.feeds

import java.text.SimpleDateFormat
import java.util.*

data class AdventFeed(
	val name: String,
	val description: String,
	val sampleChapterUrl: String?,
	val petitions: List<Petition>
) {
	fun getTodaysPetition(): Petition? {
		val dateFormat = SimpleDateFormat("yyyy-MM-dd")
		val today = dateFormat.format(Date())

		petitions.forEach { petition ->
			val petitionDate = petition.date
			if (petitionDate == today)
				return petition
		}
		return null
	}
}

data class Petition(
	val uid: String,
	val date: String,
	val title: String,
	val description: String,
	val markdown: Boolean
)