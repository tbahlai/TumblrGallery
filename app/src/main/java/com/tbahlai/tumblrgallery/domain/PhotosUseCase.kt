package com.tbahlai.tumblrgallery.domain

import com.tbahlai.tumblrgallery.data.PhotosRepository
import com.tbahlai.tumblrgallery.presentation.uimodels.UiPhotoData
import io.reactivex.Single
import javax.inject.Inject

class PhotosUseCase @Inject constructor(
    private val repository: PhotosRepository
) {

    fun getPhotosByTag(tag: String, limit: Int): Single<List<UiPhotoData>> {
        return repository.getPhotosByTag(tag, limit).map { it.response.map { it.toUiModel() } }
    }

}