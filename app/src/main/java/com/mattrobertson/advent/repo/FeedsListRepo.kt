package com.mattrobertson.advent.repo

import com.mattrobertson.advent.data.remote.FeedsListRemoteService

class FeedsListRepo {

    private val feedsService = FeedsListRemoteService()

    suspend fun getFeeds() = feedsService.getFeeds()

}