package com.mattrobertson.advent.data.json

import com.mattrobertson.advent.domain.model.feeds.*

fun mapToJson(jsonItem: AdventFeedsListItem): FeedListItem {
    return if (jsonItem.feed_url.isEmpty()) {
        FeedListNonFeedItem(
            label = jsonItem.label,
            webUrl = jsonItem.web_url,
            imageResource = jsonItem.image_resource
        )
    } else {
        FeedListFeedItem(
            label = jsonItem.label,
            feedId = getFeedIdFromUrl(jsonItem.feed_url),
            imageUrl = jsonItem.image_url
        )
    }
}

fun mapToJson(feedItem: FeedListItem): AdventFeedsListItem {
    return AdventFeedsListItem(
        label = feedItem.label,
        feed_url = if (feedItem is FeedListFeedItem) feedItem.feedId else "",
        image_url = if (feedItem is FeedListFeedItem) feedItem.imageUrl else "",
        web_url = if (feedItem is FeedListNonFeedItem) feedItem.webUrl else "",
        image_resource = if (feedItem is FeedListNonFeedItem) feedItem.imageResource else ""
    )
}

fun getFeedIdFromUrl(url: String) = url.substringAfterLast("/").replace(".json", "")

fun mapFromJson(jsonItem: AdventFeedJson): Feed {
    return Feed(
        name = jsonItem.name,
        description = jsonItem.description,
        petitions = jsonItem.petitions.map { mapFromJson(it) }
    )
}

fun mapFromJson(jsonItem: PetitionJson): Petition {
    return Petition(
        uid = jsonItem.uid,
        date = jsonItem.date,
        title = jsonItem.title,
        description = jsonItem.description,
        markdown = jsonItem.markdown
    )
}

fun mapToJson(jsonItem: Feed): AdventFeedJson {
    return AdventFeedJson(
        name = jsonItem.name,
        description = jsonItem.description,
        petitions = jsonItem.petitions.map { mapToJson(it) }
    )
}

fun mapToJson(jsonItem: Petition): PetitionJson {
    return PetitionJson(
        uid = jsonItem.uid,
        date = jsonItem.date,
        title = jsonItem.title,
        description = jsonItem.description,
        markdown = jsonItem.markdown
    )
}