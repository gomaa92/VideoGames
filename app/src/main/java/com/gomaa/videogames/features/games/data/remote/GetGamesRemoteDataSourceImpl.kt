package com.gomaa.videogames.features.games.data.remote

import com.gomaa.videogames.base.data.remote.CloudConfig
import com.gomaa.videogames.base.data.remote.NetworkResponse
import com.gomaa.videogames.features.games.data.model.entities.ListGamesResponse
import com.gomaa.videogames.features.games.data.model.params.GetGamesParams
import javax.inject.Inject

class GetGamesRemoteDataSourceImpl @Inject constructor(
    private val service: GetGamesService,
) : GetGamesRemoteDataSource {
    override suspend fun getGames(
        params: GetGamesParams
    ): NetworkResponse<ListGamesResponse> {
       return NetworkResponse.Success( service.getGames(
            CloudConfig.PUBLIC_KEY,
            "",
            params.ids,
            params.page,
            params.pageSize
        ))
      /*  return safeApiCall {
            service.getGames(
                CloudConfig.PUBLIC_KEY,
                "",
                params.ids,
                params.page,
                params.pageSize
            )
        }*/
    }
}