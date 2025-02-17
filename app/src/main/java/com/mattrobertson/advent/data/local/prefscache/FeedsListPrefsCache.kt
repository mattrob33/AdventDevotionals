package com.mattrobertson.advent.data.local.prefscache

import android.content.Context.MODE_PRIVATE
import com.mattrobertson.advent.AdventDevotionalsApplication
import com.mattrobertson.advent.data.json.AdventFeedsListSection
import com.mattrobertson.advent.data.local.ProtoLocalFeedsList
import com.mattrobertson.advent.domain.model.feeds.FeedListItem
import com.mattrobertson.advent.data.json.mapToJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class FeedsListPrefsCache: ProtoLocalFeedsList() {

	companion object {
		private const val FEEDS_CACHE = "feeds_cache"
	}

	private val prefs = AdventDevotionalsApplication.context.getSharedPreferences(
        FEEDS_CACHE, MODE_PRIVATE)

	private val moshi: Moshi = Moshi.Builder().build()
	private val moshiAdapter: JsonAdapter<AdventFeedsListSection> = moshi.adapter(AdventFeedsListSection::class.java)


	override suspend fun getFeeds(): List<FeedListItem>? {
		val json = prefs.getString("feeds", "") ?: ""
		return if (json.isNotEmpty()) {
			val section: AdventFeedsListSection? = moshiAdapter.fromJson(json)
			section?.let { section ->
				section.items.map { mapToJson(it) }
			}
		} else {
			null
		}
	}

	override fun saveFeedsList(feeds: List<FeedListItem>) {
		val items = feeds.map { mapToJson(it) }

		val jsonSection = AdventFeedsListSection(title = "", items = items)

		val json = moshiAdapter.toJson(jsonSection)
		prefs.edit().putString("feeds", json).apply()
	}

}