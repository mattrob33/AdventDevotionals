package com.mattrobertson.advent.data

import com.mattrobertson.advent.domain.model.feeds.Feed
import com.mattrobertson.advent.domain.model.feeds.Petition

interface FeedSource {

	suspend fun getFeed(feedId: String): Feed?

	suspend fun getFeedTitle(feedId: String): String?

	suspend fun getTodaysPetition(feedId: String): Petition?

}