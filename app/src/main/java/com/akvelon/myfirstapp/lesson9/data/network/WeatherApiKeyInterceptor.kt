package com.akvelon.myfirstapp.lesson9.data.network

import com.akvelon.myfirstapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class WeatherApiKeyInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()
        val url = originalHttpUrl.newBuilder()
                .addQueryParameter("appid", BuildConfig.WEATHER_API_KEY)
                .build()

        return chain.proceed(original.newBuilder().url(url).build())
    }
}