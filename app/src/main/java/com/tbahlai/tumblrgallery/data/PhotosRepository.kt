package com.tbahlai.tumblrgallery.data

import com.tbahlai.tumblrgallery.data.api.PhotosApiService
import com.tbahlai.tumblrgallery.data.api.models.ApiResponseData
import io.reactivex.Single
import retrofit2.HttpException
import javax.inject.Inject

class PhotosRepository @Inject constructor(
    private val apiService: PhotosApiService
) {

    fun getPhotosByTag(tag: String, limit: Int) : Single<ApiResponseData> {
        return apiService.getPhotosByTag(tag, limit).flatMap {
            if (it.isSuccessful) {
                Single.fromCallable { it.body() }
            } else {
                Single.error { HttpException(it) }
            }
        }
    }

}