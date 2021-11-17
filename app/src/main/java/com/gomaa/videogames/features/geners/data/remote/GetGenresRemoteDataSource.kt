package com.gomaa.videogames.features.geners.data.remote

import com.gomaa.videogames.base.data.remote.NetworkResponse
import com.gomaa.videogames.base.data.remote.NetworkServiceCall
import com.gomaa.videogames.features.geners.domain.data.entities.GenresResponse

interface GetGenresRemoteDataSource : NetworkServiceCall {
    suspend fun getGenres(
    ): NetworkResponse<GenresResponse>
}