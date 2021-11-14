package com.gomaa.videogames.base.di.local

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefsStore @Inject constructor(private val sharedPreferences: SharedPreferences) :
    ISharedPrefsStore {


    /**
     * Save string
     *
     * @param key
     * @param value
     */
    override fun saveString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            this?.putString(key, value)
            this?.apply()
        }
    }

    /**
     * Get string
     *
     * @param key
     * @return
     */
    override fun getString(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }

}