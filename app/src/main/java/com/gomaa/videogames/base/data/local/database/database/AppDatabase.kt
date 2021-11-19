package com.gomaa.videogames.base.data.local.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gomaa.videogames.features.games.data.model.entities.ListGamesResponse

@Database(
    entities = [ListGamesResponse::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: AppDatabase? = null
        private const val databaseName = "VideoGamesDB"
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: buildDataBase(context).apply { INSTANCE = this }
        }

        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, databaseName)
                .build()
    }

}