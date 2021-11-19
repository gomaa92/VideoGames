package com.gomaa.videogames.features.games.data.remote

import com.gomaa.videogames.base.data.remote.NetworkResponse
import com.gomaa.videogames.features.games.domain.model.entities.ListGamesResponse
import com.gomaa.videogames.features.games.domain.model.params.GetGamesParams

interface GetGamesRemoteDataSource {
    suspend fun getGames(
        params: GetGamesParams
    ): NetworkResponse<ListGamesResponse>
}