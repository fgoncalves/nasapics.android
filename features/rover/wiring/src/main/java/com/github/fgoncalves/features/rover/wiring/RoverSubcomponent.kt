package com.github.fgoncalves.features.rover.wiring

import com.github.fgoncalves.features.rover.RoverComponent
import com.github.fgoncalves.foundation.commons.FeatureScope
import dagger.Subcomponent

@FeatureScope
@Subcomponent(
    modules = [
        RoverModule::class,
    ]
)
interface RoverSubcomponent : RoverComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): RoverComponent
    }
}
