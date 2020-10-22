package com.github.fgoncalves.features.rover

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.github.fgoncalves.features.rover.domain.entities.RoverPhoto
import com.github.fgoncalves.features.rover.domain.usecases.GetRoverPhotosUseCase
import com.github.fgoncalves.foundation.commons.notifyPropertyChanges
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

abstract class RoverViewModel : ViewModel(), LifecycleObserver {
    class State : BaseObservable() {
        @get:Bindable
        var photos by notifyPropertyChanges(emptyList<RoverPhoto>(), BR.photos)
    }

    abstract val state: State
}

class RoverViewModelImpl @Inject constructor(
    private val getRoverPhotosUseCase: GetRoverPhotosUseCase
) : RoverViewModel() {
    private val disposables = CompositeDisposable()

    override val state = State()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onScreenResumed() {
        disposables += getRoverPhotosUseCase.get()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    state.photos = it
                },
                onError = {
                    Log.e("RoverViewModel", "Failed to get rover pictures", it)
                }
            )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onScreenPaused() {
        disposables.clear()
    }
}
