package com.github.fgoncalves.nasapics

import com.github.fgoncalves.features.apod.wiring.ApodSubcomponent
import com.github.fgoncalves.features.rover.wiring.RoverSubcomponent
import dagger.Module

@Module(
    subcomponents = [
        ApodSubcomponent::class,
        RoverSubcomponent::class,
    ]
)
interface SubcomponentModule
