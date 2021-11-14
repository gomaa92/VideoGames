package com.gomaa.videogames.base.extensions

import androidx.lifecycle.LiveData
import com.gomaa.videogames.base.presentation.viewmodel.SingleLiveEvent

fun <T> LiveData<T>.toSingleLiveEvent(): LiveData<T> {
    val result = SingleLiveEvent<T>()
    result.addSource(this) {
        result.value = it
    }
    return result
}