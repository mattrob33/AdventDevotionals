package com.mattrobertson.advent.data.remote

import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AdventFeedServiceTest {

	lateinit var feedService: AdventFeedService

	@Before
	fun setup() {
		feedService = AdventFeedService()
	}

	@Test
	fun `feed not null`() = runBlocking {
		val feed = feedService.getFeed("f5308ae92fbad141a19f71c2616720644faa5")
		assertNotNull(feed)
	}
}