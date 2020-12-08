package com.mattrobertson.advent.data.remote

import com.mattrobertson.advent.data.json.AdventFeedsList
import com.mattrobertson.advent.domain.model.feeds.FeedListItem
import com.mattrobertson.advent.data.json.mapToJson
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class FeedsListRemoteService {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val service: FeedsService = retrofit.create(FeedsService::class.java)


    suspend fun getFeeds(): List<FeedListItem> {
        val sections = service.getFeeds()
        return sections.sections[0].items.map {  jsonItem ->
            mapToJson(jsonItem)
        }
    }

    interface FeedsService {
        @GET("/galleries/dev_challenge.json")
        suspend fun getFeeds(): AdventFeedsList
    }

    companion object {
        const val BASE_URL = "https://prayermate-dt.s3.eu-west-2.amazonaws.com"
    }
}