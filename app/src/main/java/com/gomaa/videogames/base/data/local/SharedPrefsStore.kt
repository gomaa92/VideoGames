package com.gomaa.videogames.base.data.local

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

    override fun saveBoolean(key: String, value: Boolean) {
        with(sharedPreferences.edit()) {
            this?.putBoolean(key, value)
            this?.apply()
        }
    }

    override fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

}