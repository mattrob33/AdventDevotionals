package com.mattrobertson.advent.data.json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdventFeedJson(
    val name: String,
    val description: String,
    val image_url: String = "",
    val iphone_app_url: Any? = null,
    val homepage: String? = null,
    val twitter_handle: String? = null,
    val approved: Boolean? = null,
    val subscribe_url: String? = null,
    val image_updated_at: String? = null,
    val notify_daily: Boolean? = null,
    val default_list: Any? = null,
    val minimum_android_client: Int? = null,
    val minimum_client: String? = null,
    val sample_chapter_url: String? = null,
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