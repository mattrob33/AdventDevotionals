package com.mattrobertson.advent.data.remote

import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FeedRemoteServiceTest {

	lateinit var feedRemoteService: FeedRemoteService

	@Before
	fun setup() {
		feedRemoteService = FeedRemoteService()
	}

	@Test
	fun `feed not null`() = runBlocking {
		val feed = feedRemoteService.getFeed("f5308ae92fbad141a19f71c2616720644faa5")
		assertNotNull(feed)
	}
}