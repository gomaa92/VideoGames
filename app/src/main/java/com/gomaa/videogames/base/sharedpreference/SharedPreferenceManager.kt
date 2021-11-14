package com.gomaa.videogames.base.sharedpreference

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(private val encryptedSharedPreferences: SharedPreferences) {

    fun putSharedPrefValues(vararg entries: Pair<String, Any>) {
        encryptedSharedPreferences.edit().apply {
            entries.forEach { (key, value) ->
                putItem(key, value)
            }
        }.apply()
    }

    private fun SharedPreferences.Editor.putItem(key: String, value: Any) {
        when (value) {
            is String -> putString(key, value)
            is Boolean -> putBoolean(key, value)
            else -> throw IllegalArgumentException("${value.javaClass} is not supported")
        }
    }

    fun getString(key: String, defaultValue: String? = null) =
        encryptedSharedPreferences.getString(key, defaultValue)

    fun getBoolean(key: String, defaultValue: Boolean = false) =
        encryptedSharedPreferences.getBoolean(key, defaultValue)

}