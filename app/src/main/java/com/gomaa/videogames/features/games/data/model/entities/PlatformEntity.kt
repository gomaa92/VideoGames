package com.gomaa.videogames.features.games.data.model.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity
data class PlatformEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val name: String
)