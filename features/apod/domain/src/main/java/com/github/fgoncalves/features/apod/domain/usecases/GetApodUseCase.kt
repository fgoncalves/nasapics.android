package com.github.fgoncalves.features.apod.domain.usecases

import com.github.fgoncalves.features.apod.domain.entities.Apod
import com.github.fgoncalves.features.apod.domain.repositories.ApodRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface GetApodUseCase {
    /**
     * Get the astronomy pic of the day
     */
    fun get(): Single<Apod>
}

class GetApodUseCaseImpl @Inject constructor(
    private val repository: ApodRepository
) : GetApodUseCase {
    override fun get() = repository.get()
}
