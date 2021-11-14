package com.gomaa.videogames.base.domain.usecase

interface SuspendableUseCase<I,O> {
    suspend fun execute(input: I?= null): O
}