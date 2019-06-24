package com.akvelon.myfirstapp.lesson3.data.repository.weather;

import androidx.annotation.NonNull;

import com.akvelon.myfirstapp.lesson3.data.models.DayForecastResponse;
import com.akvelon.myfirstapp.lesson3.network.clients.WeatherClient;

import retrofit2.Call;

public class WeatherRepositoryImpl implements WeatherRepository {

    @NonNull
    private final WeatherClient client;

    public WeatherRepositoryImpl(@NonNull WeatherClient client) {
        this.client = client;
    }

    @Override
    public Call<DayForecastResponse> getDayForecast(@NonNull String city) {
        return client.getDailyForecastByCity(city);
    }
}
