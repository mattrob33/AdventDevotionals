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