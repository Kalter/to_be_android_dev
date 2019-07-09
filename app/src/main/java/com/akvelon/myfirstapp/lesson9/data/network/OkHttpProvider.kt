package com.akvelon.myfirstapp.lesson9.data.network

import com.akvelon.myfirstapp.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttpProvider {

    fun provideClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(WeatherApiKeyInterceptor())
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            builder.addNetworkInterceptor(StethoInterceptor())
        }

        return builder.build()
    }

}