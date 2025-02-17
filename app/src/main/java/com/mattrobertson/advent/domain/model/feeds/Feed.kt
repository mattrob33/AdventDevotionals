package com.mattrobertson.advent.domain.model.feeds

import com.mattrobertson.advent.utils.getTodaysDate

data class Feed(
	val name: String,
	val description: String,
	val petitions: List<Petition>
) {

	fun getTodaysPetition(): Petition? {
		val today = getTodaysDate()

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