package com.mattrobertson.advent.domain.model.feeds

import com.mattrobertson.advent.data.json.AdventFeedsListItem

fun map(jsonItem: AdventFeedsListItem): FeedListItem {
    return if (jsonItem.feed_url.isEmpty()) {
        FeedListNonFeedItem(
            label = jsonItem.label,
            webUrl = jsonItem.web_url,
            imageResource = jsonItem.image_resource
        )
    } else {
        FeedListFeedItem(
            label = jsonItem.label,
            feedUrl = jsonItem.feed_url,
            imageUrl = jsonItem.image_url
        )
    }
}