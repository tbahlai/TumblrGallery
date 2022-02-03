package com.tbahlai.tumblrgallery.data.api

import com.tbahlai.tumblrgallery.data.api.models.ApiResponseData
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosApiService {

    @GET("v2/tagged")
    fun getPhotosByTag(
        @Query("tag") tag: String,
        @Query("limit") limit: Int,
    ): Single<Response<ApiResponseData>>

}