package com.mattrobertson.advent.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mattrobertson.advent.data.local.db.model.FeedEntity

@Dao
interface FeedDao {

    @Query("SELECT * FROM feeds WHERE feed_id = :feedId")
    suspend fun getFeed(feedId: String): FeedEntity?

    @Query("SELECT * FROM feeds")
    suspend fun getAllFeeds(): List<FeedEntity>

    @Insert
    suspend fun insert(entity: FeedEntity)

    @Insert
    suspend fun insertAll(vararg feedEntities: FeedEntity)

    @Delete
    suspend fun delete(feedEntity: FeedEntity)

}