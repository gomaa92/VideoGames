package com.gomaa.videogames.features.games.data.model.params

data class GetGamesParams(
    var ids: List<Int>? = null,
    val page: Int? = null,
    val pageSize: Int? = null
)
