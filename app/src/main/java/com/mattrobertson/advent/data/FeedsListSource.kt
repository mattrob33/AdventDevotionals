package com.mattrobertson.advent.data

import com.mattrobertson.advent.domain.model.feeds.FeedListItem

interface FeedsListSource {
	suspend fun getFeeds(): List<FeedListItem>?
}