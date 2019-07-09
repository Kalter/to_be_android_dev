package com.akvelon.myfirstapp.lesson9.data.network

import com.akvelon.myfirstapp.BuildConfig
import com.akvelon.myfirstapp.lesson7.data.network.OkHttpProvider

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private var sRetrofit: Retrofit? = null

    private var httpClient: OkHttpClient? = null

    val retrofitInstance: Retrofit
        get() {
            if (sRetrofit == null) {
                sRetrofit = Retrofit.Builder()
                        .baseUrl(BuildConfig.API_BASE_URL)
                        .client(provideClient())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
            }
            return sRetrofit!!

        }

    private fun provideClient(): OkHttpClient {
        if (httpClient == null) {
            httpClient = OkHttpProvider.provideClient()
        }
        return httpClient!!
    }
}