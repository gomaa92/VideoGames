package com.gomaa.videogames.features.geners.data.model.entities

import com.google.gson.annotations.SerializedName

data class GenresObject(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("games_count") val gamesCount: Int?,
    @SerializedName("image_background") val imageBackground: String?,
    var isSelected: Boolean = false
)