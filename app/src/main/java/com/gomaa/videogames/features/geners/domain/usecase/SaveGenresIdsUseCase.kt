package com.gomaa.videogames.features.geners.domain.usecase

import com.gomaa.videogames.base.domain.usecase.SuspendableUseCase
import com.gomaa.videogames.features.geners.domain.repository.GetGenresRepository
import com.gomaa.videogames.features.geners.presentation.viewmodel.GetGenresResult
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SaveGenresIdsUseCase @Inject constructor(
    private val repository: GetGenresRepository
) : SuspendableUseCase<ArrayList<Int>, GetGenresResult> {
    override suspend fun execute(input: ArrayList<Int>?): GetGenresResult {
        if (input != null)
            repository.saveGenresId(input)

        return GetGenresResult.SavedId
    }
}