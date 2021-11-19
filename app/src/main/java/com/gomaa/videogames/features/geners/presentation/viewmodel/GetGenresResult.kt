package com.gomaa.videogames.features.geners.presentation.viewmodel

import com.gomaa.videogames.base.presentation.viewmodel.Result
import com.gomaa.videogames.features.geners.data.model.entities.GenresResponse

sealed class GetGenresResult : Result {
    object Loading : GetGenresResult()
    data class Success(val response: GenresResponse?) : GetGenresResult()
    object Failure : GetGenresResult()
    object SavedId : GetGenresResult()
}