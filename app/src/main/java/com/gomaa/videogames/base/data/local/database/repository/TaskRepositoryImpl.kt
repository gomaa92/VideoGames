package com.gomaa.videogames.base.data.local.database.repository

import com.gomaa.videogames.base.data.local.database.database.AppDatabase

abstract class TaskRepositoryImpl<T>(protected val appDatabase: AppDatabase) : TaskRepository<T> {
    override suspend fun insertTask(item: T): Long = getDao().insert(item)
    override suspend fun getTasks(): List<T> = getDao().getTasks()

}