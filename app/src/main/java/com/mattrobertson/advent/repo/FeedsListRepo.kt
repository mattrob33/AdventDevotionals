package com.mattrobertson.advent.repo

import com.mattrobertson.advent.data.remote.AdventFeedsListService

class FeedsListRepo {

    private val feedsService = AdventFeedsListService()

    suspend fun getFeeds() = feedsService.getFeeds()

}