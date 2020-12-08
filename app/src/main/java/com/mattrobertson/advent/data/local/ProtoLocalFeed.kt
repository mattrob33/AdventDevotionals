package com.mattrobertson.advent.data.local

import com.mattrobertson.advent.data.FeedSource
import com.mattrobertson.advent.domain.model.feeds.Feed

abstract class ProtoLocalFeed: FeedSource {

	abstract suspend fun saveFeed(feedId: String, feed: Feed)

}