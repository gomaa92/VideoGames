package com.gomaa.videogames.features.geners.data.remote

import com.gomaa.videogames.base.data.remote.CloudConfig
import com.gomaa.videogames.base.data.remote.NetworkResponse
import com.gomaa.videogames.features.geners.domain.data.entities.GenresResponse
import javax.inject.Inject

class GetGenresRemoteDataSourceImpl @Inject constructor(
    private val service: GetGenresService,
) : GetGenresRemoteDataSource {
    override suspend fun getGenres(): NetworkResponse<GenresResponse> {
        return safeApiCall {
            service.getGenres(
                CloudConfig.PUBLIC_KEY,
                ""
            )
        }
    }
}