package com.akvelon.myfirstapp.lesson3.data.models;

import com.google.gson.annotations.SerializedName;

public class DayForecastResponse {

    @SerializedName("main")
    private DayForecastInfo dayForecastInfo;

    public DayForecastInfo getDayForecastInfo() {
        return dayForecastInfo;
    }
}
