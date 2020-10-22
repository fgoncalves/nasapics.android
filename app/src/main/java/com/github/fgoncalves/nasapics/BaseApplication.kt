package com.github.fgoncalves.nasapics

import android.app.Application
import com.github.fgoncalves.features.apod.pub.ApodComponentProvider
import com.github.fgoncalves.features.rover.RoverComponentProvider


class BaseApplication : Application(), ApodComponentProvider, RoverComponentProvider {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }

    override fun provideApodComponent() =
        applicationComponent.apodComponent().create()

    override fun provideRoverComponent() =
        applicationComponent.roverComponent().create()
}
