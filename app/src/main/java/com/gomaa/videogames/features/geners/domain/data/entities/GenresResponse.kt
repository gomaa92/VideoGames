package com.gomaa.videogames.features.geners.domain.data.entities

import com.google.gson.annotations.SerializedName

data class GenresResponse(
    @SerializedName("count") val count : Int,
    @SerializedName("next") val next : String,
    @SerializedName("previous") val previous : String,
    @SerializedName("results") val results : List<GenresObject>
)