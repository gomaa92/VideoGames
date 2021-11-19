package com.gomaa.videogames.features.games.data.model.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity
data class RequirementsEntity(
    @SerializedName("minimum") val minimum : String,
    @SerializedName("recommended") val recommended : String
)
