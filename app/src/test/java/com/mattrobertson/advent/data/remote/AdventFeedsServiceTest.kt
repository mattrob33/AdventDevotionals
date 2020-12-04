package com.mattrobertson.advent.data.remote

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AdventFeedsServiceTest {

	lateinit var feedsService: AdventFeedsListService

	@Before
	fun setup() {
		feedsService = AdventFeedsListService()
	}

	@Test
	fun `feeds not null`() = runBlocking {
		val feeds = feedsService.getFeeds()
		assertEquals(8, feeds.size)
	}
}