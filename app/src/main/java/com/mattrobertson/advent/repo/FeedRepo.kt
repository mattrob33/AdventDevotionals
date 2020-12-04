package com.mattrobertson.advent.repo

import com.mattrobertson.advent.data.remote.FeedService

class FeedRepo {

    private val feedService = FeedService()

    suspend fun getFeed(feedId: String) = feedService.getFeed(feedId)

}