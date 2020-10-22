package com.github.fgoncalves.features.rover.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RoverPhoto(
    @Json(name = "id")
    val id: Long,
    @Json(name = "img_src")
    val imageUrl: String,
)
