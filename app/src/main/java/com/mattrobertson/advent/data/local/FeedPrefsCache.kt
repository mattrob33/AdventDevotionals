package com.mattrobertson.advent.data.local

import android.content.Context.MODE_PRIVATE
import com.mattrobertson.advent.AdventDevotionalsApplication
import com.mattrobertson.advent.data.json.AdventFeedJson
import com.mattrobertson.advent.domain.model.feeds.AdventFeed
import com.mattrobertson.advent.domain.model.feeds.map
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FeedPrefsCache: ProtoLocalFeed() {

	companion object {
		private const val FEED_CACHE = "feed_cache"
	}

	private val prefs = AdventDevotionalsApplication.applicationContext.getSharedPreferences(FEED_CACHE, MODE_PRIVATE)

	private val moshi: Moshi = Moshi.Builder().build()
	private val moshiAdapter: JsonAdapter<AdventFeedJson> = moshi.adapter(AdventFeedJson::class.java)


	override suspend fun getFeed(feedId: String): AdventFeed? {
		val json = prefs.getString(feedId, "") ?: ""
		return if (json.isNotEmpty()) {
			map(moshiAdapter.fromJson(json)!!)
		} else {
			null
		}
	}

	override fun saveFeed(feedId: String, feed: AdventFeed) {
		val feedJsonItem = map(feed)
		val json = moshiAdapter.toJson(feedJsonItem)
		prefs.edit().putString(feedId, json).apply()
	}

}