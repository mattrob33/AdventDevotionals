package com.mattrobertson.advent.data.remote

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AdventFeedsTest {

	lateinit var feedsService: AdventFeeds

	@Before
	fun setup() {
		feedsService = AdventFeeds()
	}

	@Test
	fun `feeds not null`() = runBlocking {
		val feeds = feedsService.getFeeds().execute().body()!!
		assert(feeds.string() != "")
	}
}