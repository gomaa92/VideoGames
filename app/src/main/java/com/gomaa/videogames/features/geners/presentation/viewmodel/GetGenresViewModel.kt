package com.gomaa.videogames.features.geners.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.gomaa.videogames.base.presentation.viewmodel.BaseViewModel
import com.gomaa.videogames.features.geners.domain.usecase.GetGenresUseCase
import com.gomaa.videogames.features.geners.domain.usecase.SaveGenresIdsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class GetGenresViewModel @Inject constructor(
    private val useCase: GetGenresUseCase,
    private val saveUseCase: SaveGenresIdsUseCase
) : BaseViewModel<GetGenresViewState, GetGenresActions, GetGenresResult>() {
    override val internalViewState: GetGenresViewState
        get() = GetGenresViewState.InitialState

    //TODO should be provided by Hilt
    private val context = viewModelScope.coroutineContext + Dispatchers.Default

    private lateinit var genresIds: ArrayList<Int>

    override fun handle(action: GetGenresActions): LiveData<GetGenresResult> = liveData(context) {
        when (action) {
            is GetGenresActions.GetGeneresAction -> {
                emit(GetGenresResult.Loading)
                emit(useCase.execute())

            }
            is GetGenresActions.HandleGenresId -> handleGenresId(action.id)
            GetGenresActions.FinishSelectGenres -> emit(saveUseCase.execute(genresIds))
        }
    }

    private fun handleGenresId(id: Int) {
        genresIds = ArrayList()
        if (genresIds.contains(id)) {
            genresIds.remove(id)
            return
        }
        genresIds.add(id)
    }

    override fun reduce(result: GetGenresResult): GetGenresViewState {
        return when (result) {
            GetGenresResult.Failure -> GetGenresViewState.Failure
            GetGenresResult.Loading -> GetGenresViewState.Loading
            is GetGenresResult.Success -> GetGenresViewState.Success(response = result.response)
            GetGenresResult.SavedId -> GetGenresViewState.FinishSaveIds
        }
    }
}