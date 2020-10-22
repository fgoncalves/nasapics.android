package com.github.fgoncalves.features.apod.domain.repositories

import com.github.fgoncalves.features.apod.data.clients.ApodApiClient
import com.github.fgoncalves.features.apod.domain.entities.Apod
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface ApodRepository {
    /**
     * Get the picture of the day
     */
    fun get(): Single<Apod>
}

class ApodRepositoryImpl @Inject constructor(
    private val apiClient: ApodApiClient
) : ApodRepository {
    override fun get(): Single<Apod> =
        apiClient.get()
            .map {
                Apod(
                    it.copyright,
                    it.date,
                    it.explanation,
                    it.title,
                    it.url,
                )
            }
}
