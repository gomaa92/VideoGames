package com.gomaa.videogames.features.games.presentation.viewmodel

import com.gomaa.videogames.base.presentation.viewmodel.ViewState
import com.gomaa.videogames.features.games.data.model.entities.ListGamesResponse

sealed class GetGamesViewState : ViewState {
    object Loading : GetGamesViewState()
    object Initial : GetGamesViewState()
    data class Success(val response: ListGamesResponse?) : GetGamesViewState()
    object Failure : GetGamesViewState()
}