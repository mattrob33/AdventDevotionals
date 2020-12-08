package com.mattrobertson.advent.data.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "petitions")
data class PetitionEntity(
    @PrimaryKey val uid: String,
    val feed_id: String,
    val date: String,
    val title: String,
    val description: String,
    val markdown: Boolean
)