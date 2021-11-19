package com.gomaa.videogames.features.geners.presentation.view.listener

import com.gomaa.videogames.features.geners.data.model.entities.GenresObject

interface OnGenresClickListener {
    fun onItemClicked(item: GenresObject,position: Int)
}