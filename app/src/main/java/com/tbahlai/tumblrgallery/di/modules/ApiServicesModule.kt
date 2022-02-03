package com.tbahlai.tumblrgallery.di.modules

import com.tbahlai.tumblrgallery.data.api.PhotosApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiServicesModule {

    @Provides
    fun providesTumblrApiService(retrofit: Retrofit): PhotosApiService {
        return retrofit.create(PhotosApiService::class.java)
    }

}