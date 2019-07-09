package com.akvelon.myfirstapp.lesson9.data.models

import com.google.gson.annotations.SerializedName

data class DayForecastResponse(
        @SerializedName("main") val dayForecastInfo: DayForecastInfo
)
