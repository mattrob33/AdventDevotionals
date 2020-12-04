package com.mattrobertson.advent.utils

import com.mattrobertson.advent.domain.model.feeds.getFeedIdFromUrl
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UtilityFunctionsTest {

	@Test
	fun `test getFeedIdFromUrl`() {
		val feedId = getFeedIdFromUrl("https://prayermate.s3-eu-west-1.amazonaws.com/f5308ae92fbad141a19f71c2616720644faa5.json")
		assertEquals("f5308ae92fbad141a19f71c2616720644faa5", feedId)
	}
}