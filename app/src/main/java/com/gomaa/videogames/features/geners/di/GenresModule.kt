package com.gomaa.videogames.features.geners.di

import com.gomaa.videogames.features.geners.data.remote.GetGenresRemoteDataSource
import com.gomaa.videogames.features.geners.data.remote.GetGenresRemoteDataSourceImpl
import com.gomaa.videogames.features.geners.data.repository.GetGenresRepositoryImpl
import com.gomaa.videogames.features.geners.domain.repository.GetGenresRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class GenresModule {

    @Binds
    abstract fun provideGenresRepository(repository: GetGenresRepositoryImpl): GetGenresRepository

    @Binds
    abstract fun provideGenresRemoteDataSourceModel(
        remoteDataSource: GetGenresRemoteDataSourceImpl
    ): GetGenresRemoteDataSource
}