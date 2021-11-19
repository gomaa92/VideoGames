package com.gomaa.videogames.features.games.domain.repository

import com.gomaa.videogames.base.data.remote.NetworkResponse
import com.gomaa.videogames.features.games.domain.model.entities.ListGamesResponse
import com.gomaa.videogames.features.games.domain.model.params.GetGamesParams

interface GetGamesRepository {
    suspend fun getGenres(
        params: GetGamesParams
    ): NetworkResponse<ListGamesResponse>
}