package com.akvelon.myfirstapp.lesson9.data.models

import com.google.gson.annotations.SerializedName

data class WeatherInfo(@SerializedName("id") val id: Long = 0,
                       @SerializedName("main") val weatherMainInfo: String,
                       @SerializedName("description") val weatherDescription: String,
                       @SerializedName("icon") val iconUrl: String
) 
