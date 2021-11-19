package com.gomaa.videogames.features.games.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.gomaa.videogames.base.presentation.viewmodel.BaseViewModel
import com.gomaa.videogames.base.utils.PAGE_SIZE
import com.gomaa.videogames.features.games.domain.model.params.GetGamesParams
import com.gomaa.videogames.features.games.domain.usecase.GetGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class GetGamesViewModel @Inject constructor(
    private val useCase: GetGamesUseCase
) : BaseViewModel<GetGamesViewState, GetGamesAction, GetGamesResult>() {
    private var page = 0
    override val internalViewState: GetGamesViewState
        get() = GetGamesViewState.Initial

    //TODO should be provided by Hilt
    private val context = viewModelScope.coroutineContext + Dispatchers.Default

    override fun handle(action: GetGamesAction): LiveData<GetGamesResult> = liveData(context) {
        when (action) {
            is GetGamesAction.GetGames -> {
                val params = GetGamesParams(page = ++page, pageSize = PAGE_SIZE)
                emit(useCase.execute(params))
            }
        }

    }

    override fun reduce(result: GetGamesResult): GetGamesViewState {
        return when (result) {
            GetGamesResult.Failure -> GetGamesViewState.Failure
            GetGamesResult.Loading -> GetGamesViewState.Loading
            is GetGamesResult.Success -> GetGamesViewState.Success(response = result.response)
        }
    }
}