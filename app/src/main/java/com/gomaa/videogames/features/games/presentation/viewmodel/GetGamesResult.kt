package com.gomaa.videogames.features.games.presentation.viewmodel

import com.gomaa.videogames.base.presentation.viewmodel.Result
import com.gomaa.videogames.features.games.domain.model.entities.ListGamesResponse

sealed class GetGamesResult : Result {
    object Loading : GetGamesResult()
    data class Success(val response: ListGamesResponse?) : GetGamesResult()
    object Failure : GetGamesResult()
}