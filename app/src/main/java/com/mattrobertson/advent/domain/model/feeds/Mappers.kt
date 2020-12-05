package com.mattrobertson.advent.domain.model.feeds

import com.mattrobertson.advent.data.json.AdventFeedJson
import com.mattrobertson.advent.data.json.AdventFeedsListItem
import com.mattrobertson.advent.data.json.PetitionJson

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
            feedId = getFeedIdFromUrl(jsonItem.feed_url),
            imageUrl = jsonItem.image_url
        )
    }
}

fun map(feedItem: FeedListItem): AdventFeedsListItem {
    return AdventFeedsListItem(
        label = feedItem.label,
        feed_url = if (feedItem is FeedListFeedItem) feedItem.feedId else "",
        image_url = if (feedItem is FeedListFeedItem) feedItem.imageUrl else "",
        web_url = if (feedItem is FeedListNonFeedItem) feedItem.webUrl else "",
        image_resource = if (feedItem is FeedListNonFeedItem) feedItem.imageResource else ""
    )
}

fun getFeedIdFromUrl(url: String) = url.substringAfterLast("/").replace(".json", "")

fun map(jsonItem: AdventFeedJson): AdventFeed {
    return AdventFeed(
        name = jsonItem.name,
        description = jsonItem.description,
        sampleChapterUrl = jsonItem.sample_chapter_url,
        petitions = jsonItem.petitions.map { map(it) }
    )
}

fun map(jsonItem: PetitionJson): Petition {
    return Petition(
        uid = jsonItem.uid,
        date = jsonItem.date,
        title = jsonItem.title,
        description = jsonItem.description,
        markdown = jsonItem.markdown
    )
}

fun map(jsonItem: AdventFeed): AdventFeedJson {
    return AdventFeedJson(
        name = jsonItem.name,
        description = jsonItem.description,
        sample_chapter_url = jsonItem.sampleChapterUrl,
        petitions = jsonItem.petitions.map { map(it) }
    )
}

fun map(jsonItem: Petition): PetitionJson {
    return PetitionJson(
        uid = jsonItem.uid,
        date = jsonItem.date,
        title = jsonItem.title,
        description = jsonItem.description,
        markdown = jsonItem.markdown
    )
}