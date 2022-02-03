package com.tbahlai.tumblrgallery.presentation.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tbahlai.tumblrgallery.common.BaseViewModel
import com.tbahlai.tumblrgallery.domain.PhotosUseCase
import com.tbahlai.tumblrgallery.presentation.uimodels.UiPhotoOriginalSize
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class GalleryViewModel @Inject constructor(
    private val useCase: PhotosUseCase
) : BaseViewModel() {

    var searchSubject = PublishSubject.create<String>()
    var searchKeyword: String? = null
        private set

    val imagesLiveData : LiveData<List<UiPhotoOriginalSize>>
        get() = _imagesLiveData
    private val _imagesLiveData = MutableLiveData<List<UiPhotoOriginalSize>>()

    val showProgressIndicatorLiveData: LiveData<Boolean>
        get() = _showProgressIndicatorLiveData
    private val _showProgressIndicatorLiveData = MutableLiveData<Boolean>()

    fun setupSearchSubject() {
        disposable += searchSubject
            .filter { (searchKeyword ?: "") != it }
            .debounce(1L, TimeUnit.SECONDS)
            .switchMap { entry -> Observable.fromCallable { searchKeyword = entry } }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getImagesByTag()
            }, {

            })
    }

    fun getImagesByTag() {
        _showProgressIndicatorLiveData.value = true

        disposable += useCase.getPhotosByTag(searchKeyword ?: "", LIMIT_SIZE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { _showProgressIndicatorLiveData.value = false }
            .subscribe(
                { photoData ->
                    val list = mutableListOf<UiPhotoOriginalSize>()
                    photoData.map { it.photos?.let { it.map { list += it.originalSize } } }
                    _imagesLiveData.value = list
                },
                {  }
            )
    }

    companion object {
        private const val LIMIT_SIZE = 50
    }

}