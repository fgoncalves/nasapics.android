package com.github.fgoncalves.features.rover.data.clients

import com.github.fgoncalves.features.rover.data.ROVER_PHOTOS_PATH
import com.github.fgoncalves.features.rover.data.entities.RoverPhotos
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RoverPhotosApiClient {
    @GET(ROVER_PHOTOS_PATH)
    fun get(
        sol: Long,
    ): Single<RoverPhotos>
}
