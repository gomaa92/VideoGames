package com.gomaa.videogames.features.games.data.repository

import android.util.Log
import com.gomaa.videogames.base.data.local.sharedpref.ISharedPrefsStore
import com.gomaa.videogames.base.data.local.sharedpref.SharedPreferencesConstants
import com.gomaa.videogames.base.data.remote.NetworkResponse
import com.gomaa.videogames.features.games.data.remote.GetGamesRemoteDataSource
import com.gomaa.videogames.features.games.data.model.entities.ListGamesResponse
import com.gomaa.videogames.features.games.data.model.params.GetGamesParams
import com.gomaa.videogames.features.games.domain.repository.GetGamesRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

class GetGamesRepositoryImpl @Inject constructor(
    private val remoteDataSource: GetGamesRemoteDataSource,
    private val sharedPrefsStore: ISharedPrefsStore,
    private val gson: Gson
) : GetGamesRepository {
    override suspend fun getGenres(params: GetGamesParams): NetworkResponse<ListGamesResponse> {
        params.ids = getGenresIds()
        Log.d("GetGamesRepositoryImpl", "getGenres: ${params.ids}")
        Log.d("GetGamesRepositoryImpl", "getGenres: ${params.page}")
        Log.d("GetGamesRepositoryImpl", "getGenres: ${params.pageSize}")
        return remoteDataSource.getGames(params)
    }

    private fun getGenresIds(): ArrayList<Int>? {
        val ids =
            sharedPrefsStore.getString(SharedPreferencesConstants.SAVED_GENRES_IDS)
        val type: Type = object : TypeToken<List<Int?>?>() {}.type
        return gson.fromJson(ids, type)
    }
}