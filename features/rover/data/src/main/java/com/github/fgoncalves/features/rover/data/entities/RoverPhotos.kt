package com.github.fgoncalves.features.rover.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RoverPhotos(
    @Json(name = "photos")
    val photos: List<RoverPhoto> = emptyList(),
)
