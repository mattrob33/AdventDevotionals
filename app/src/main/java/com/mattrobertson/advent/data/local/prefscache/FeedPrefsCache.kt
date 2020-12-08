package com.mattrobertson.advent.data.local.prefscache

import android.content.Context.MODE_PRIVATE
import com.mattrobertson.advent.AdventDevotionalsApplication
import com.mattrobertson.advent.data.json.AdventFeedJson
import com.mattrobertson.advent.data.local.ProtoLocalFeed
import com.mattrobertson.advent.domain.model.feeds.Feed
import com.mattrobertson.advent.domain.model.feeds.Petition
import com.mattrobertson.advent.data.json.mapToJson
import com.mattrobertson.advent.data.json.mapFromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class FeedPrefsCache: ProtoLocalFeed() {

	companion object {
		private const val FEED_CACHE = "feed_cache"
	}

	private val prefs = AdventDevotionalsApplication.context.getSharedPreferences(
        FEED_CACHE, MODE_PRIVATE)

	private val moshi: Moshi = Moshi.Builder().build()
	private val moshiAdapter: JsonAdapter<AdventFeedJson> = moshi.adapter(AdventFeedJson::class.java)


	override suspend fun getFeed(feedId: String): Feed? {
		val json = prefs.getString(feedId, "") ?: ""
		return if (json.isNotEmpty()) {
			mapFromJson(moshiAdapter.fromJson(json)!!)
		} else {
			null
		}
	}

	override suspend fun getFeedTitle(feedId: String): String? {
		val json = prefs.getString(feedId, "") ?: ""
		return if (json.isNotEmpty()) {
			mapFromJson(moshiAdapter.fromJson(json)!!).name
		} else {
			null
		}
	}

	override suspend fun getTodaysPetition(feedId: String): Petition? {
		val json = prefs.getString(feedId, "") ?: ""
		return if (json.isNotEmpty()) {
			mapFromJson(moshiAdapter.fromJson(json)!!).getTodaysPetition()
		} else {
			null
		}
	}

	override suspend fun saveFeed(feedId: String, feed: Feed) {
		val feedJsonItem = mapToJson(feed)
		val json = moshiAdapter.toJson(feedJsonItem)
		prefs.edit().putString(feedId, json).apply()
	}

}