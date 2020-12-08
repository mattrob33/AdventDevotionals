package com.mattrobertson.advent.data.local.cache

import com.mattrobertson.advent.data.local.ProtoLocalFeed
import com.mattrobertson.advent.data.local.db.AppDatabase
import com.mattrobertson.advent.data.local.db.mapFromEntity
import com.mattrobertson.advent.data.local.db.mapToEntity
import com.mattrobertson.advent.domain.model.feeds.Feed
import com.mattrobertson.advent.domain.model.feeds.Petition
import com.mattrobertson.advent.utils.getTodaysDate

class FeedCache: ProtoLocalFeed() {

	private val db = AppDatabase.getInstance()

	private val feedDao = db.feedDao()
	private val petitionDao = db.petitionDao()

	override suspend fun getFeed(feedId: String): Feed? {
		val feedInfo = feedDao.getFeed(feedId)
		val petitions = petitionDao.getAllPetitionsForFeed(feedId)

		if (feedInfo == null) return null

		return Feed(
			name = feedInfo.name,
			description = feedInfo.description,
			petitions = petitions.map { mapFromEntity(it) }
		)
	}

	override suspend fun getFeedTitle(feedId: String) = feedDao.getFeed(feedId)?.name

	override suspend fun getTodaysPetition(feedId: String): Petition? {
		val today = getTodaysDate()
		val petitionEntity = petitionDao.getPetition(feedId, today)

		return if (petitionEntity == null)
			null
		else
			mapFromEntity(petitionEntity)
	}

	override suspend fun saveFeed(feedId: String, feed: Feed) {
		feedDao.insert(
			mapToEntity(feed, feedId)
		)

		petitionDao.insertAll(
			feed.petitions.map { petition ->
				mapToEntity(petition, feedId)
			}
		)
	}

}