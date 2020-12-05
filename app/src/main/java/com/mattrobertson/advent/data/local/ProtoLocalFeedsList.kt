package com.mattrobertson.advent.data.local

import com.mattrobertson.advent.data.FeedsListStore
import com.mattrobertson.advent.domain.model.feeds.FeedListItem

abstract class ProtoLocalFeedsList: FeedsListStore {

	abstract fun saveFeedsList(feeds: List<FeedListItem>)

}