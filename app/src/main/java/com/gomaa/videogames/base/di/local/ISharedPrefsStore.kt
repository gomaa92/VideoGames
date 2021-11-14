package com.gomaa.videogames.base.di.local

interface ISharedPrefsStore {
    fun saveString(key: String, value: String)
    fun getString(key: String): String
}