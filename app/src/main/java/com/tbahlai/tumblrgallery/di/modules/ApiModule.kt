package com.tbahlai.tumblrgallery.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tbahlai.tumblrgallery.BuildConfig
import com.tbahlai.tumblrgallery.data.api.interceptors.RetrofitLoggerInterceptor
import com.tbahlai.tumblrgallery.data.api.interceptors.TokenInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun providesOkHttp(
        tokenInterceptor: TokenInterceptor,
    ): OkHttpClient {
        val build = OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .addInterceptor(RetrofitLoggerInterceptor(RetrofitLoggerInterceptor.Level.BODY))
            .build()
        return build
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

}