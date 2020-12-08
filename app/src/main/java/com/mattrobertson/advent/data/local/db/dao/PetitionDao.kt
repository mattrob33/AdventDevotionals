package com.mattrobertson.advent.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mattrobertson.advent.data.local.db.model.PetitionEntity

@Dao
interface PetitionDao {

    @Query("SELECT * FROM petitions WHERE feed_id = :feedId AND date = :date ORDER BY date ASC")
    suspend fun getPetition(feedId: String, date: String): PetitionEntity?

    @Query("SELECT * FROM petitions WHERE feed_id = :feedId ORDER BY date ASC")
    suspend fun getAllPetitionsForFeed(feedId: String): List<PetitionEntity>

    @Insert
    suspend fun insertAll(vararg petitions: PetitionEntity)

    @Insert
    suspend fun insertAll(petitions: List<PetitionEntity>)

    @Delete
    suspend fun delete(petition: PetitionEntity)

}