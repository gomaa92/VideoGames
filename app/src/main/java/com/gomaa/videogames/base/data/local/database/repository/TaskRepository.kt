package com.gomaa.videogames.base.data.local.database.repository

import com.gomaa.videogames.base.data.local.database.dao.TaskDao

interface TaskRepository<T> {
    fun getDao(): TaskDao<T>
    suspend fun insertTask(item: T): Long
    suspend fun getTasks(): List<T>
}