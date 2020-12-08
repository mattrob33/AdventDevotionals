package com.mattrobertson.advent.data.local

import com.mattrobertson.advent.data.FeedsListSource
import com.mattrobertson.advent.domain.model.feeds.FeedListItem

abstract class ProtoLocalFeedsList: FeedsListSource {

	abstract fun saveFeedsList(feeds: List<FeedListItem>)

}