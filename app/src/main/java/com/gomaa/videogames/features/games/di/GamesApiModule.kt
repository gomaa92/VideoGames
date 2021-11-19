package com.gomaa.videogames.features.games.di

import com.gomaa.videogames.features.games.data.remote.GetGamesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
class GamesApiModule {
    @Provides
    fun provideGamesApi(retrofit: Retrofit): GetGamesService {
        return retrofit.create(GetGamesService::class.java)
    }
}