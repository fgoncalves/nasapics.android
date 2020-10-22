package com.github.fgoncalves.foundation.commons

import androidx.databinding.BaseObservable
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * BaseObservable delegate that can be used to notify that a given property has become dirty
 */
fun <T> BaseObservable.notifyPropertyChanges(
    initialValue: T,
    propertyId: Int
) =
    object : ReadWriteProperty<Any?, T> {
        private var value = initialValue

        override fun getValue(thisRef: Any?, property: KProperty<*>) = value

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            value.takeIf { it != this.value }
                ?.let {
                    this.value = it
                    notifyPropertyChanged(propertyId)
                }
        }
    }
