package com.gomaa.videogames.features.geners.presentation.view.listener

import com.gomaa.videogames.features.geners.domain.data.entities.GenresObject
import java.text.FieldPosition

interface OnGenresClickListener {
    fun onItemClicked(item: GenresObject,position: Int)
}