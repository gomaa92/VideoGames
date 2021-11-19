package com.gomaa.videogames.features.games.data.model.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity
data class ListGamesResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: List<GameEntity>
)
