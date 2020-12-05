package com.mattrobertson.advent.repo

import com.mattrobertson.advent.data.FeedsListStore
import com.mattrobertson.advent.data.local.FeedsListPrefsCache
import com.mattrobertson.advent.data.remote.FeedsListRemoteService
import com.mattrobertson.advent.domain.model.feeds.FeedListItem

class FeedsListRepo: FeedsListStore {

    private val feedsRemote = FeedsListRemoteService()
    private val feedsLocal = FeedsListPrefsCache()

    override suspend fun getFeeds(): List<FeedListItem> {
        val local = feedsLocal.getFeeds()
        if (local != null) return local

        val remote = feedsRemote.getFeeds()
        feedsLocal.saveFeedsList(remote)
        return remote
    }

}