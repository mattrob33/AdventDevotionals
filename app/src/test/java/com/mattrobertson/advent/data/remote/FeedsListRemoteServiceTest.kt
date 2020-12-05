package com.mattrobertson.advent.data.remote

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FeedsListRemoteServiceTest {

	lateinit var feedsRemoteService: FeedsListRemoteService

	@Before
	fun setup() {
		feedsRemoteService = FeedsListRemoteService()
	}

	@Test
	fun `feeds not null`() = runBlocking {
		val feeds = feedsRemoteService.getFeeds()
		assertEquals(8, feeds.size)
	}
}