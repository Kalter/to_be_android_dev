package com.akvelon.myfirstapp.lesson4.rxweather.data.repository.weather;

import androidx.annotation.NonNull;

import com.akvelon.myfirstapp.lesson4.rxweather.data.models.DayForecastResponse;
import com.akvelon.myfirstapp.lesson4.rxweather.network.clients.RxWeatherClient;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class RxWeatherRepositoryImpl implements RxWeatherRepository {

    @NonNull
    private final RxWeatherClient client;

    public RxWeatherRepositoryImpl(@NonNull RxWeatherClient client) {
        this.client = client;
    }

    @Override
    public Single<DayForecastResponse> getDayForecast(@NonNull String city) {
        return client.getDailyForecastByCity(city);
    }
}
