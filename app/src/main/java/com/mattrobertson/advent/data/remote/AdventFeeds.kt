package com.mattrobertson.advent.data.remote

import com.mattrobertson.advent.data.json.AdventFeedsList
import com.mattrobertson.advent.domain.model.feeds.FeedListItem
import com.mattrobertson.advent.domain.model.feeds.map
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class AdventFeeds {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val service: AdventFeedsService = retrofit.create(AdventFeedsService::class.java)


    suspend fun getFeeds(): List<FeedListItem> {
        val sections = service.getFeeds()
        return sections.sections[0].items.map {  jsonItem ->
            map(jsonItem)
        }
    }

    interface AdventFeedsService {
        @GET("/galleries/dev_challenge.json")
        suspend fun getFeeds(): AdventFeedsList
    }

    companion object {
        const val BASE_URL = "https://prayermate-dt.s3.eu-west-2.amazonaws.com"
    }
}