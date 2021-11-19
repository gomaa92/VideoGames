package com.gomaa.videogames.base.di.local

import com.gomaa.videogames.base.data.local.sharedpref.ISharedPrefsStore
import com.gomaa.videogames.base.data.local.sharedpref.SharedPrefsStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalStorageModule {

    @Binds
    abstract fun provideSharedPrefsStore(repository: SharedPrefsStore): ISharedPrefsStore

}