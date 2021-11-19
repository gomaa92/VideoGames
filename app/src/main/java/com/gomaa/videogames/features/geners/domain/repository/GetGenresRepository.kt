package com.gomaa.videogames.features.geners.domain.repository

import com.gomaa.videogames.base.data.remote.NetworkResponse
import com.gomaa.videogames.features.geners.data.model.entities.GenresResponse

interface GetGenresRepository {
    suspend fun getGenres(): NetworkResponse<GenresResponse>

    suspend fun saveGenresId(ids: ArrayList<Int>)
    suspend fun saveGenresOpen(): Boolean
}