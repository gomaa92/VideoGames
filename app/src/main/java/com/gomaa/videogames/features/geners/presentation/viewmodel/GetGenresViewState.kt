package com.gomaa.videogames.features.geners.presentation.viewmodel

import com.gomaa.videogames.base.presentation.viewmodel.ViewState
import com.gomaa.videogames.features.geners.domain.data.entities.GenresResponse

sealed class GetGenresViewState:ViewState {
    object InitialState : GetGenresViewState()
    object Loading : GetGenresViewState()
    data class Success(val response: GenresResponse?) : GetGenresViewState()
    object Failure : GetGenresViewState()
    object FinishSaveIds : GetGenresViewState()
}