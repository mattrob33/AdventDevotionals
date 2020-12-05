package com.mattrobertson.advent.data.remote

import com.mattrobertson.advent.data.json.AdventFeedJson
import com.mattrobertson.advent.domain.model.feeds.AdventFeed
import com.mattrobertson.advent.domain.model.feeds.map
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class FeedRemoteService {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val service: AdventFeedRetrofit = retrofit.create(AdventFeedRetrofit::class.java)


    suspend fun getFeed(feedId: String): AdventFeed = map(service.getFeed(feedId))

    interface AdventFeedRetrofit {
        @GET("/{feedId}.json")
        suspend fun getFeed(@Path("feedId") feedId: String): AdventFeedJson
    }

    companion object {
        const val BASE_URL = "https://prayermate.s3-eu-west-1.amazonaws.com"
    }
}