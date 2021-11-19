package com.gomaa.videogames.features.games.domain.model.entities

import com.google.gson.annotations.SerializedName

data class ListGamesResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: List<GameEntity>
)
