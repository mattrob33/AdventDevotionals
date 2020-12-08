package com.mattrobertson.advent.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mattrobertson.advent.data.local.db.model.FeedItemEntity

@Dao
interface FeedListFeedItemDao {

    @Query("SELECT * FROM feed_items")
    suspend fun getAll(): List<FeedItemEntity>

    @Insert
    suspend fun insertAll(vararg feedEntities: FeedItemEntity)

    @Delete
    suspend fun delete(feedEntity: FeedItemEntity)

}