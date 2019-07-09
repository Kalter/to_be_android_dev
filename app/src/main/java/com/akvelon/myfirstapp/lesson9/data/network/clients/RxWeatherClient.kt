package com.akvelon.myfirstapp.lesson9.data.network.clients

import com.akvelon.myfirstapp.lesson9.data.models.DayForecastResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RxWeatherClient {

    @GET("/data/2.5/weather")
    fun getDailyForecastByCity(@Query("q") cityName: String): Single<DayForecastResponse>
}