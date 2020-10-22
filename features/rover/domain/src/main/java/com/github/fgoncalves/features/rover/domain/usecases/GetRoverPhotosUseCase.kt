package com.github.fgoncalves.features.rover.domain.usecases

import com.github.fgoncalves.features.rover.domain.entities.RoverPhoto
import com.github.fgoncalves.features.rover.domain.repositories.RoverPhotoRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface GetRoverPhotosUseCase {
    /**
     * Get the rover pictures from a random sol
     */
    fun get(): Single<List<RoverPhoto>>
}

class GetRoverPhotosUseCaseImpl @Inject constructor(
    private val repository: RoverPhotoRepository
) : GetRoverPhotosUseCase {
    override fun get() = repository.get(1000)
}
