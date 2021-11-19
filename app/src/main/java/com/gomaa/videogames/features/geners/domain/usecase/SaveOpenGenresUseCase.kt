package com.gomaa.videogames.features.geners.domain.usecase

import com.gomaa.videogames.base.domain.usecase.SuspendableUseCase
import com.gomaa.videogames.features.geners.domain.repository.GetGenresRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SaveOpenGenresUseCase @Inject constructor(
    private val repository: GetGenresRepository
) : SuspendableUseCase<Unit, Boolean> {
    override suspend fun execute(input: Unit?): Boolean {
        return repository.saveGenresOpen()
    }
}