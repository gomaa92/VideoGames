package com.gomaa.videogames.features.games.domain.usecase

import com.gomaa.videogames.base.data.remote.NetworkResponse
import com.gomaa.videogames.base.domain.usecase.SuspendableUseCase
import com.gomaa.videogames.features.games.data.model.params.GetGamesParams
import com.gomaa.videogames.features.games.domain.repository.GetGamesRepository
import com.gomaa.videogames.features.games.presentation.viewmodel.GetGamesResult
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetGamesUseCase @Inject constructor(
    private val repository: GetGamesRepository
) : SuspendableUseCase<GetGamesParams, GetGamesResult> {
    override suspend fun execute(input: GetGamesParams?): GetGamesResult {
        return if (input != null)
            when (val response = repository.getGenres(input)) {
                is NetworkResponse.Success -> {
                    GetGamesResult.Success(response.data)
                }
                is NetworkResponse.Failure -> {
                    GetGamesResult.Failure
                }
            }
        else when (val response = repository.getGenres(GetGamesParams())) {
            is NetworkResponse.Success -> {
                GetGamesResult.Success(response.data)
            }
            is NetworkResponse.Failure -> {
                GetGamesResult.Failure
            }
        }
    }
}