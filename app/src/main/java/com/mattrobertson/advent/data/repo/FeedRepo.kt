package com.mattrobertson.advent.data.repo

import com.mattrobertson.advent.data.FeedSource
import com.mattrobertson.advent.data.local.cache.FeedCache
import com.mattrobertson.advent.data.remote.FeedRemoteService
import com.mattrobertson.advent.domain.model.feeds.Feed
import com.mattrobertson.advent.domain.model.feeds.Petition

class FeedRepo: FeedSource {

    private val feedRemote = FeedRemoteService()
    private val feedLocal = FeedCache()

    override suspend fun getFeed(feedId: String): Feed {
        val localData = feedLocal.getFeed(feedId)
        if (localData != null) return localData

        val remoteData = feedRemote.getFeed(feedId)
        feedLocal.saveFeed(feedId, remoteData)
        return remoteData
    }

    override suspend fun getFeedTitle(feedId: String): String {
        val localData = feedLocal.getFeedTitle(feedId)
        if (localData != null) return localData

        val remoteData = feedRemote.getFeed(feedId)
        feedLocal.saveFeed(feedId, remoteData)
        return remoteData.name
    }

    override suspend fun getTodaysPetition(feedId: String): Petition? {
        val localData = feedLocal.getTodaysPetition(feedId)
        if (localData != null) return localData

        val remoteData = feedRemote.getFeed(feedId)
        feedLocal.saveFeed(feedId, remoteData)
        return remoteData.getTodaysPetition()
    }

}