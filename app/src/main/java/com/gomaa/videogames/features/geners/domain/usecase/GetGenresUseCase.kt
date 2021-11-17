package com.gomaa.videogames.features.geners.domain.usecase

import com.gomaa.videogames.base.data.remote.NetworkResponse
import com.gomaa.videogames.base.domain.usecase.SuspendableUseCase
import com.gomaa.videogames.features.geners.domain.repository.GetGenresRepository
import com.gomaa.videogames.features.geners.presentation.viewmodel.GetGenresResult
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetGenresUseCase @Inject constructor(
    private val repository: GetGenresRepository
) : SuspendableUseCase<Unit, GetGenresResult> {
    override suspend fun execute(input: Unit?): GetGenresResult {
        return when (val response = repository.getGenres()) {
            is NetworkResponse.Success -> {
                GetGenresResult.Success(response.data)
            }
            is NetworkResponse.Failure -> {
                GetGenresResult.Failure
            }
        }

    }
}