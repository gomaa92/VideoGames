package com.gomaa.videogames.features.games.domain.model.entities

import com.google.gson.annotations.SerializedName

data class PlatformEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val name: String
)