package com.tbahlai.tumblrgallery.data.api.interceptors

import com.tbahlai.tumblrgallery.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val httpUrl = request.url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()
        request = request.newBuilder().url(httpUrl).build()

        return chain.proceed(request)
    }

}