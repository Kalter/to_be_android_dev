package com.akvelon.myfirstapp.lesson9.data.models

import com.google.gson.annotations.SerializedName

data class DayTempInfo(
        @SerializedName("day") val dayTemp: Float = 0.toFloat(),
        @SerializedName("min") val minTemp: Float = 0.toFloat(),
        @SerializedName("max") val maxTemp: Float = 0.toFloat(),
        @SerializedName("night") val nightTemp: Float = 0.toFloat(),
        @SerializedName("eve") val eveningTemp: Float = 0.toFloat(),
        @SerializedName("morn") val morningTemp: Float = 0.toFloat()
)
