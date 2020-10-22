package com.github.fgoncalves.features.rover.domain.repositories

import com.github.fgoncalves.features.rover.data.clients.RoverPhotosApiClient
import com.github.fgoncalves.features.rover.domain.entities.RoverPhoto
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface RoverPhotoRepository {
    /**
     * Get the picture of the day
     */
    fun get(sol: Long): Single<List<RoverPhoto>>
}

class RoverPhotoRepositoryImpl @Inject constructor(
    private val apiClient: RoverPhotosApiClient
) : RoverPhotoRepository {
    override fun get(sol: Long): Single<List<RoverPhoto>> =
        apiClient.get(sol)
            .map { roverPhotos ->
                roverPhotos.photos.map {
                    RoverPhoto(
                        it.id,
                        it.imageUrl,
                    )
                }
            }
}
