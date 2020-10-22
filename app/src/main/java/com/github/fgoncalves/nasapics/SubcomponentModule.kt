package com.github.fgoncalves.nasapics

import com.github.fgoncalves.features.apod.wiring.ApodSubcomponent
import dagger.Module

@Module(
    subcomponents = [
        ApodSubcomponent::class
    ]
)
interface SubcomponentModule
