package com.mattrobertson.advent.domain.model.feeds

sealed class FeedListItem(
    val label: String
)

class FeedListFeedItem(
    label: String,
    val subtitle: String = "",
    val feedUrl: String = "",
    val imageUrl: String = ""
): FeedListItem(label)

class FeedListNonFeedItem(
    label: String,
    val webUrl: String = "",
    val imageResource: String = ""
): FeedListItem(label)