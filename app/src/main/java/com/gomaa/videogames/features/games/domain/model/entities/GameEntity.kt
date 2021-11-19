package com.gomaa.videogames.features.games.domain.model.entities

import com.google.gson.annotations.SerializedName

data class GameEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val name: String,
    @SerializedName("released") val released: String,
    @SerializedName("tba") val tba: Boolean,
    @SerializedName("background_image") val backgroundImage: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("rating_top") val ratingTop: Double,
    @SerializedName("ratings_count") val ratingsCount: Int,
    @SerializedName("reviews_text_count") val reviewsTextCount: String,
    @SerializedName("added") val added: Int,
    @SerializedName("metacritic") val metacritic: Int,
    @SerializedName("playtime") val playtime: Int,
    @SerializedName("suggestions_count") val suggestionsCount: Int,
    @SerializedName("updated") val updated: String,
    @SerializedName("esrb_rating") val esrbRating: EsrbRatingEntity,
    @SerializedName("platforms") val platforms: List<PlatformsEntity>
)