package com.mattrobertson.advent.data.local.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mattrobertson.advent.AdventDevotionalsApplication
import com.mattrobertson.advent.data.local.db.dao.FeedDao
import com.mattrobertson.advent.data.local.db.dao.PetitionDao
import com.mattrobertson.advent.data.local.db.model.FeedEntity
import com.mattrobertson.advent.data.local.db.model.PetitionEntity

@Database(entities = [
    FeedEntity::class,
    PetitionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun feedDao(): FeedDao
    abstract fun petitionDao(): PetitionDao

    companion object {

        private const val DATABASE_NAME = "advent.db"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase().also { instance = it }
            }
        }

        private fun buildDatabase() = Room.databaseBuilder(
                AdventDevotionalsApplication.context,
                AppDatabase::class.java, DATABASE_NAME
            ).build()
    }
}