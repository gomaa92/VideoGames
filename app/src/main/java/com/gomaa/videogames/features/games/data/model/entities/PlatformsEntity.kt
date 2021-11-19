package com.gomaa.videogames.features.games.data.model.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity
data class PlatformsEntity(
    @SerializedName("platform") val platform : PlatformEntity,
    @SerializedName("released_at") val releasedAat : String,
    @SerializedName("requirements") val requirements : RequirementsEntity
)
