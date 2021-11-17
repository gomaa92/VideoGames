package com.gomaa.videogames.features.geners.di

import com.gomaa.videogames.features.geners.data.remote.GetGenresService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
class GeneresAPIModule {
    @Provides
    fun provideLogInApi(retrofit: Retrofit): GetGenresService {
        return retrofit.create(GetGenresService::class.java)
    }
}