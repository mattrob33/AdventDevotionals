package com.mattrobertson.advent.repo

import com.mattrobertson.advent.data.FeedStore
import com.mattrobertson.advent.data.local.FeedPrefsCache
import com.mattrobertson.advent.data.remote.FeedRemoteService
import com.mattrobertson.advent.domain.model.feeds.AdventFeed

class FeedRepo: FeedStore {

    private val feedRemote = FeedRemoteService()
    private val feedLocal = FeedPrefsCache()

    override suspend fun getFeed(feedId: String): AdventFeed {
        val local = feedLocal.getFeed(feedId)
        if (local != null) return local

        val remote = feedRemote.getFeed(feedId)
        feedLocal.saveFeed(feedId, remote)
        return remote
    }

}