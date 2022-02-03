package com.tbahlai.tumblrgallery.common

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    //TODO() add errorLiveData for errors handle

    protected val disposable = CompositeDisposable()

    @CallSuper
    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

}