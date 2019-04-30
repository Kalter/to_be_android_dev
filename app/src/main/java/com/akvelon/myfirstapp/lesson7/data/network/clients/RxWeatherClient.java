package com.akvelon.myfirstapp.lesson7.data.network.clients;

import com.akvelon.myfirstapp.lesson4.rxweather.data.models.DayForecastResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RxWeatherClient {

    @GET("/data/2.5/weather")
    Single<DayForecastResponse> getDailyForecastByCity(@Query("q") String cityName);

}