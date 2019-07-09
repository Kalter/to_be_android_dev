package com.akvelon.myfirstapp.lesson9.data.repository.weather

import com.akvelon.myfirstapp.lesson9.data.models.DayForecastResponse
import io.reactivex.Single

interface MvpWeatherRepository {

    fun getDayForecast(city: String): Single<DayForecastResponse>

}
