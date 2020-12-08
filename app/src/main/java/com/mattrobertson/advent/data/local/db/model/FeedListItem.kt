package com.mattrobertson.advent.data.local.db.model

import androidx.room.Entity

@Entity(tableName = "feed_items")
data class FeedItemEntity(
    val label: String,
    val subtitle: String = "",
    val feedId: String = "",
    val imageUrl: String = ""
)

@Entity(tableName = "non_feed_items")
data class NonFeedItemEntity(
    val label: String,
    val webUrl: String = "",
    val imageResource: String = ""
)