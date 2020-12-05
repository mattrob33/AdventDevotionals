package com.mattrobertson.advent.data.local

import com.mattrobertson.advent.data.FeedStore
import com.mattrobertson.advent.domain.model.feeds.AdventFeed

abstract class ProtoLocalFeed: FeedStore {

	abstract fun saveFeed(feedId: String, feed: AdventFeed)

}