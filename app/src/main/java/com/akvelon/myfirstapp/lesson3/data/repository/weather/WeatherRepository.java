package com.akvelon.myfirstapp.lesson3.data.repository.weather;

import android.support.annotation.NonNull;

import com.akvelon.myfirstapp.lesson3.data.models.DayForecastResponse;

import retrofit2.Call;

public interface WeatherRepository {

    Call<DayForecastResponse> getDayForecast(@NonNull String city);

}
