package com.akvelon.myfirstapp.lesson9.data.repository

import com.akvelon.myfirstapp.lesson9.data.network.ApiFactory
import com.akvelon.myfirstapp.lesson9.data.network.clients.RxWeatherClient
import com.akvelon.myfirstapp.lesson9.data.repository.weather.MvpWeatherRepository
import com.akvelon.myfirstapp.lesson9.data.repository.weather.MvpWeatherRepositoryImpl

class MvpRepositoryProvider private constructor() {

    private var mvpWeatherRepository: MvpWeatherRepository? = null

    fun provideNewsFeedRepository(): MvpWeatherRepository {
        if (mvpWeatherRepository == null) {
            mvpWeatherRepository = MvpWeatherRepositoryImpl(getServiceInstance(RxWeatherClient::class.java))
        }
        return mvpWeatherRepository!!
    }

    companion object {

        @Volatile private var sInstance: MvpRepositoryProvider? = null

        fun get(): MvpRepositoryProvider? {
            if (sInstance == null) {
                synchronized(MvpRepositoryProvider::class.java) {
                    if (sInstance == null) {
                        sInstance = MvpRepositoryProvider()
                    }
                }
            }
            return sInstance
        }

        private fun <T> getServiceInstance(clazz: Class<T>): T {
            return ApiFactory.retrofitInstance.create(clazz)
        }
    }
}