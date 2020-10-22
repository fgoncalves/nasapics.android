package com.github.fgoncalves.features.apod.data.clients

import com.github.fgoncalves.features.apod.data.APOD_PATH
import com.github.fgoncalves.features.apod.data.entities.Apod
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApodApiClient {
    @GET(APOD_PATH)
    fun get(): Single<Apod>
}
