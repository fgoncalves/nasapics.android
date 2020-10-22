package com.github.fgoncalves.features.apod.wiring

import com.github.fgoncalves.features.apod.data.clients.ApodApiClient
import com.github.fgoncalves.features.apod.domain.repositories.ApodRepository
import com.github.fgoncalves.features.apod.domain.repositories.ApodRepositoryImpl
import com.github.fgoncalves.features.apod.domain.usecases.GetApodUseCase
import com.github.fgoncalves.features.apod.domain.usecases.GetApodUseCaseImpl
import com.github.fgoncalves.features.apod.pub.ApodViewModel
import com.github.fgoncalves.features.apod.pub.ApodViewModelImpl
import com.github.fgoncalves.foundation.commons.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
interface ApodModule {
    companion object {
        @Provides
        @FeatureScope
        fun providesApiClient(retrofit: Retrofit) = retrofit.create<ApodApiClient>()
    }

    @Binds
    @FeatureScope
    fun providesApodRepository(apodRepositoryImpl: ApodRepositoryImpl): ApodRepository

    @Binds
    @FeatureScope
    fun providesGetApodUsecase(apodUseCaseImpl: GetApodUseCaseImpl): GetApodUseCase

    @Binds
    @FeatureScope
    fun providesApodViewModel(apodViewModel: ApodViewModelImpl): ApodViewModel
}
