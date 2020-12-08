package com.mattrobertson.advent.data.local.db

import com.mattrobertson.advent.data.local.db.model.FeedEntity
import com.mattrobertson.advent.data.local.db.model.PetitionEntity
import com.mattrobertson.advent.domain.model.feeds.Feed
import com.mattrobertson.advent.domain.model.feeds.Petition

fun mapFromEntity(entity: PetitionEntity): Petition = Petition(
    uid = entity.uid,
    date = entity.date,
    title = entity.title,
    description = entity.description,
    markdown = entity.markdown
)

fun mapToEntity(petition: Petition, feedId: String): PetitionEntity = PetitionEntity(
    uid = petition.uid,
    feed_id = feedId,
    date = petition.date,
    title = petition.title,
    description = petition.description,
    markdown = petition.markdown
)

fun mapToEntity(feed: Feed, feedId: String): FeedEntity = FeedEntity(
    feed_id = feedId,
    name = feed.name,
    description = feed.description
)