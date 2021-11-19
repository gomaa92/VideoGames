package com.gomaa.videogames.base.data.local.database.dao

import androidx.room.Insert

interface TaskDao<T> {
    @Insert
    suspend fun insert(item: T): Long

    suspend fun getTasks(): List<@JvmSuppressWildcards T>

}