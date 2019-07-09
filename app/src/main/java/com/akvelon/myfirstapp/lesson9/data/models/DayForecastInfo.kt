package com.akvelon.myfirstapp.lesson9.data.models

import com.google.gson.annotations.SerializedName

data class DayForecastInfo(
        @SerializedName("temp") val dayTempInfo: Float = 0.toFloat(),
        @SerializedName("pressure") val pressure: Float = 0.toFloat(),
        @SerializedName("humidity") val humidity: Int = 0,
        @SerializedName("weather") val weatherInfo: List<WeatherInfo>? = null)
