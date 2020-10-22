package com.github.fgoncalves.features.apod.pub

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.github.fgoncalves.features.apod.domain.usecases.GetApodUseCase
import com.github.fgoncalves.foundation.commons.notifyPropertyChanges
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

abstract class ApodViewModel : ViewModel(), LifecycleObserver {
    class State : BaseObservable() {
        @get:Bindable
        var copyright by notifyPropertyChanges(null as String?, BR.copyright)

        @get:Bindable
        var date by notifyPropertyChanges("", BR.date)

        @get:Bindable
        var explanation by notifyPropertyChanges("", BR.explanation)

        @get:Bindable
        var title by notifyPropertyChanges("", BR.title)

        @get:Bindable
        var url by notifyPropertyChanges("", BR.url)
    }

    abstract val state: State
}

class ApodViewModelImpl @Inject constructor(
    private val getApodUseCase: GetApodUseCase
) : ApodViewModel() {
    private val disposables = CompositeDisposable()

    override val state = State()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onScreenResumed() {
        disposables += getApodUseCase.get()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    state.apply {
                        copyright = it.copyright
                        date = it.date
                        explanation = it.explanation
                        title = it.title
                        url = it.url
                    }
                },
                onError = {
                    Log.e("ApodViewModel", "Failed to get astronomy picture of the day", it)
                }
            )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onScreenPaused() {
        disposables.clear()
    }
}
