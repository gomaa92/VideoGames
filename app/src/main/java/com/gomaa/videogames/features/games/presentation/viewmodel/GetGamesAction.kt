package com.gomaa.videogames.features.games.presentation.viewmodel

import com.gomaa.videogames.base.presentation.viewmodel.Action

sealed class GetGamesAction : Action {
    data class GetGames(val page: Int? = null, val pageSize: Int? = null) : GetGamesAction()
}