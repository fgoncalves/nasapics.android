package com.github.fgoncalves.features.rover.data.clients

import com.github.fgoncalves.features.rover.data.ROVER_PHOTOS_PATH
import com.github.fgoncalves.features.rover.data.entities.RoverPhotos
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RoverPhotosApiClient {
    @GET(ROVER_PHOTOS_PATH)
    fun get(
        @Query("sol") sol: Long,
    ): Single<RoverPhotos>
}
