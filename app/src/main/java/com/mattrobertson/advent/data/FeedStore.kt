package com.mattrobertson.advent.data

import com.mattrobertson.advent.domain.model.feeds.AdventFeed

interface FeedStore {
	suspend fun getFeed(feedId: String): AdventFeed?
}