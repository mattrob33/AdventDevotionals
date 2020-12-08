package com.mattrobertson.advent.data.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feeds")
data class FeedEntity(
    @PrimaryKey val feed_id: String,
    val name: String,
    val description: String
)