package com.gomaa.videogames.features.games.di

import com.gomaa.videogames.features.games.data.remote.GetGamesRemoteDataSource
import com.gomaa.videogames.features.games.data.remote.GetGamesRemoteDataSourceImpl
import com.gomaa.videogames.features.games.data.repository.GetGamesRepositoryImpl
import com.gomaa.videogames.features.games.domain.repository.GetGamesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class GenresModule {

    @Binds
    abstract fun provideGamesRepository(repository: GetGamesRepositoryImpl): GetGamesRepository

    @Binds
    abstract fun provideGamesRemoteDataSourceModel(
        remoteDataSource: GetGamesRemoteDataSourceImpl
    ): GetGamesRemoteDataSource
}