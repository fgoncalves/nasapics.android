package com.github.fgoncalves.features.apod.domain.entities

data class Apod(
    val copyright: String?,
    val date: String,
    val explanation: String,
    val title: String,
    val url: String,
)
