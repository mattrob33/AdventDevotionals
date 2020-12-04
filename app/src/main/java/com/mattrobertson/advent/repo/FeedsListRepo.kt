package com.mattrobertson.advent.repo

import com.mattrobertson.advent.data.remote.FeedsListService

class FeedsListRepo {

    private val feedsService = FeedsListService()

    suspend fun getFeeds() = feedsService.getFeeds()

}