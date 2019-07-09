package com.akvelon.myfirstapp.lesson9.data.repository.weather


import com.akvelon.myfirstapp.lesson9.data.models.DayForecastResponse
import com.akvelon.myfirstapp.lesson9.data.network.clients.RxWeatherClient
import io.reactivex.Single

class MvpWeatherRepositoryImpl(private val client: RxWeatherClient) : MvpWeatherRepository {

    override fun getDayForecast(city: String): Single<DayForecastResponse> {
        return client.getDailyForecastByCity(city)
    }
}
