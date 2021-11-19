package com.gomaa.videogames.features.games.domain.model.entities

import com.google.gson.annotations.SerializedName

data class RequirementsEntity(
    @SerializedName("minimum") val minimum : String,
    @SerializedName("recommended") val recommended : String
)
