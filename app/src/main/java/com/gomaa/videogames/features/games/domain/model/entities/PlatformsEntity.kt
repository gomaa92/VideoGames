package com.gomaa.videogames.features.games.domain.model.entities

import com.google.gson.annotations.SerializedName

data class PlatformsEntity(
    @SerializedName("platform") val platform : PlatformEntity,
    @SerializedName("released_at") val releasedAat : String,
    @SerializedName("requirements") val requirements : RequirementsEntity
)
