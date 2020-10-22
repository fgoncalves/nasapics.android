package com.github.fgoncalves.nasapics

import com.github.fgoncalves.features.apod.wiring.ApodSubcomponent
import com.github.fgoncalves.foundation.commons.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        SubcomponentModule::class,
    ]
)
interface ApplicationComponent {
    fun apodComponent(): ApodSubcomponent.Factory

    fun inject(application: BaseApplication)
}
