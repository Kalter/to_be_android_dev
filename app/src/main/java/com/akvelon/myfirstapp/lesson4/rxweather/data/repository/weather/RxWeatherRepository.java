package com.akvelon.myfirstapp.lesson4.rxweather.data.repository.weather;

import androidx.annotation.NonNull;

import com.akvelon.myfirstapp.lesson4.rxweather.data.models.DayForecastResponse;

import io.reactivex.Single;

public interface RxWeatherRepository {

    Single<DayForecastResponse> getDayForecast(@NonNull String city);

}
