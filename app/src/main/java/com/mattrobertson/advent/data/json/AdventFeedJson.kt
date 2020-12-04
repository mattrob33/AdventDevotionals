package com.mattrobertson.advent.data.json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdventFeedJson(
    val name: String,
    val description: String,
    val image_url: String,
    val iphone_app_url: Any?,
    val homepage: String?,
    val twitter_handle: String?,
    val approved: Boolean?,
    val subscribe_url: String?,
    val image_updated_at: String?,
    val notify_daily: Boolean?,
    val default_list: Any?,
    val minimum_android_client: Int?,
    val minimum_client: String?,
    val sample_chapter_url: String?,
    val petitions: List<PetitionJson>,
)

@JsonClass(generateAdapter = true)
data class PetitionJson(
    val uid: String,
    val date: String,
    val title: String,
    val description: String,
    val markdown: Boolean
)