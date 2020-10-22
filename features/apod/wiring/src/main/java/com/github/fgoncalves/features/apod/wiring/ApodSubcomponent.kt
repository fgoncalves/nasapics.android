package com.github.fgoncalves.features.apod.wiring

import com.github.fgoncalves.features.apod.pub.ApodComponent
import com.github.fgoncalves.foundation.commons.FeatureScope
import dagger.Subcomponent

@FeatureScope
@Subcomponent(
    modules = [
        ApodModule::class,
    ]
)
interface ApodSubcomponent : ApodComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): ApodComponent
    }
}
