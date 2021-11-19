package com.gomaa.videogames.features.geners.presentation.viewmodel

import com.gomaa.videogames.base.presentation.viewmodel.Action

sealed class GetGenresActions : Action {
    object FirstOpen : GetGenresActions()
    object GetGeneresAction : GetGenresActions()
    data class HandleGenresId(val id: Int) : GetGenresActions()
    object FinishSelectGenres : GetGenresActions()

}