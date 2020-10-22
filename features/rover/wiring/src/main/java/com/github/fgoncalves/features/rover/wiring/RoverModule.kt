package com.github.fgoncalves.features.rover.wiring

import com.github.fgoncalves.features.rover.RoverViewModel
import com.github.fgoncalves.features.rover.RoverViewModelImpl
import com.github.fgoncalves.features.rover.data.clients.RoverPhotosApiClient
import com.github.fgoncalves.features.rover.domain.repositories.RoverPhotoRepository
import com.github.fgoncalves.features.rover.domain.repositories.RoverPhotoRepositoryImpl
import com.github.fgoncalves.features.rover.domain.usecases.GetRoverPhotosUseCase
import com.github.fgoncalves.features.rover.domain.usecases.GetRoverPhotosUseCaseImpl
import com.github.fgoncalves.foundation.commons.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
interface RoverModule {
    companion object {
        @Provides
        @FeatureScope
        fun providesApiClient(retrofit: Retrofit) = retrofit.create<RoverPhotosApiClient>()
    }

    @Binds
    @FeatureScope
    fun providesRoverPhotoRepository(repository: RoverPhotoRepositoryImpl): RoverPhotoRepository

    @Binds
    @FeatureScope
    fun providesGetRoverPhotosUseCase(useCase: GetRoverPhotosUseCaseImpl): GetRoverPhotosUseCase

    @Binds
    @FeatureScope
    fun providesRoverViewModel(apodViewModel: RoverViewModelImpl): RoverViewModel
}
