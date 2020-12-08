package com.mattrobertson.advent.data.repo

import com.mattrobertson.advent.data.FeedsListSource
import com.mattrobertson.advent.data.local.prefscache.FeedsListPrefsCache
import com.mattrobertson.advent.data.remote.FeedsListRemoteService
import com.mattrobertson.advent.domain.model.feeds.FeedListItem

class FeedsListRepo: FeedsListSource {

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