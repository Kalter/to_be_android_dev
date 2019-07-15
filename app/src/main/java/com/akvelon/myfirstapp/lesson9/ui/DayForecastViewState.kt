package com.akvelon.myfirstapp.lesson9.ui

sealed class DayForecastViewState {
    object Loading : DayForecastViewState()
    class Success(val temp: Float) : DayForecastViewState()
}