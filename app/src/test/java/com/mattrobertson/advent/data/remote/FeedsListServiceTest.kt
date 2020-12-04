package com.mattrobertson.advent.data.remote

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FeedsListServiceTest {

	lateinit var feedsService: FeedsListService

	@Before
	fun setup() {
		feedsService = FeedsListService()
	}

	@Test
	fun `feeds not null`() = runBlocking {
		val feeds = feedsService.getFeeds()
		assertEquals(8, feeds.size)
	}
}