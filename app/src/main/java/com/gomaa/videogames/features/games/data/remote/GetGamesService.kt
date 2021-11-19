package com.gomaa.videogames.features.games.data.remote

import com.gomaa.videogames.base.data.remote.CloudConfig
import com.gomaa.videogames.features.games.data.model.entities.ListGamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GetGamesService {
    @GET(CloudConfig.GET_GAMES)
    suspend fun getGames(
        @Query("key") key: String,
        @Query("dates") date: String,
        @Query("genres") ids: List<Int>?,
        @Query("page") page: Int?,
        @Query("page_size") pageSize: Int?,
    ): ListGamesResponse
}