package com.akvelon.myfirstapp.lesson7.data.repository.weather;

import androidx.annotation.NonNull;

import com.akvelon.myfirstapp.lesson4.rxweather.data.models.DayForecastResponse;
import com.akvelon.myfirstapp.lesson4.rxweather.network.clients.RxWeatherClient;

import io.reactivex.Single;

public class MvpWeatherRepositoryImpl implements MvpWeatherRepository {

    @NonNull
    private final RxWeatherClient client;

    public MvpWeatherRepositoryImpl(@NonNull RxWeatherClient client) {
        this.client = client;
    }

    @Override
    public Single<DayForecastResponse> getDayForecast(@NonNull String city) {
        return client.getDailyForecastByCity(city);
    }
}
