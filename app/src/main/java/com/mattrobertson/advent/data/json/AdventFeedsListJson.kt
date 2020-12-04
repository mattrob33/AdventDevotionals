package com.mattrobertson.advent.data.json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdventFeedsList(
    val sections: List<AdventFeedsListSection>
)

@JsonClass(generateAdapter = true)
data class AdventFeedsListSection(
    val title: String,
    val items: List<AdventFeedsListItem>
)

@JsonClass(generateAdapter = true)
data class AdventFeedsListItem(
    val label: String,
    val subtitle: String = "",
    val feed_url: String = "",
    val image_url: String = "",
    val web_url: String = "",
    val image_resource: String = ""
)