package com.gomaa.videogames.features.geners.data.repository

import com.gomaa.videogames.base.data.local.ISharedPrefsStore
import com.gomaa.videogames.base.data.local.SharedPreferencesConstants
import com.gomaa.videogames.base.data.remote.NetworkResponse
import com.gomaa.videogames.features.geners.data.remote.GetGenresRemoteDataSource
import com.gomaa.videogames.features.geners.domain.data.entities.GenresResponse
import com.gomaa.videogames.features.geners.domain.repository.GetGenresRepository
import com.google.gson.Gson
import javax.inject.Inject

class GetGenresRepositoryImpl @Inject constructor(
    private val remoteDataSource: GetGenresRemoteDataSource,
    private val sharedPrefsStore: ISharedPrefsStore,
    private val gson: Gson
) : GetGenresRepository {
    override suspend fun getGenres(): NetworkResponse<GenresResponse> {
        return remoteDataSource.getGenres()
    }

    override suspend fun saveGenresId(ids: ArrayList<Int>) {
        sharedPrefsStore.saveString(
            SharedPreferencesConstants.SAVED_GENRES_IDS,
            convertListToJson(ids)
        )
    }

    override suspend fun saveGenresOpen(): Boolean {
        sharedPrefsStore.saveBoolean(
            SharedPreferencesConstants.FIRST_LAUNCH_APP, true
        )
        return true
    }

    private fun convertListToJson(ids: ArrayList<Int>): String {
        return gson.toJson(ids)
    }
}