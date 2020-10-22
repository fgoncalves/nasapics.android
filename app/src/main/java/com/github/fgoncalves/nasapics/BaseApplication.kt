package com.github.fgoncalves.nasapics

import android.app.Application
import com.github.fgoncalves.features.apod.pub.ApodComponentProvider


class BaseApplication : Application(), ApodComponentProvider {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }

    override fun provideApodComponent() =
        applicationComponent.apodComponent().create()
}
