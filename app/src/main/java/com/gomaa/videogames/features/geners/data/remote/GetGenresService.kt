package com.gomaa.videogames.features.geners.data.remote

import com.gomaa.videogames.base.data.remote.CloudConfig
import com.gomaa.videogames.features.geners.data.model.entities.GenresResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GetGenresService {
    @GET(CloudConfig.GET_GENRES)
    suspend fun getGenres(
        @Query("key") key: String,
        @Query("dates") date: String
    ): GenresResponse
}