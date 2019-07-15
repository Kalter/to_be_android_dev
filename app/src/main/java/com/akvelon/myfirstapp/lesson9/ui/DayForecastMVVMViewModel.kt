package com.akvelon.myfirstapp.lesson9.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akvelon.myfirstapp.lesson9.data.repository.MvpRepositoryProvider
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class DayForecastMVVMViewModel : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _viewState = MutableLiveData<DayForecastViewState>()

    val viewState: LiveData<DayForecastViewState>
        get() = _viewState

    companion object {
        private const val DEFAULT_CITY = "Kazan"
    }

    override fun onCleared() {
        disposables.clear()
    }

    fun action(action: DayForecastAction) {
        when (action) {
            is DayForecastAction.FetchForecast -> fetchCityWeather(DEFAULT_CITY)
        }
    }

    private fun fetchCityWeather(city: String) {
        disposables += MvpRepositoryProvider.get()!!
                .provideNewsFeedRepository()
                .getDayForecast(city)
                .flatMap { Single.just(it.dayForecastInfo.dayTempInfo) }
                .map(this::fromKelvinToCelsius)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { _viewState.value = DayForecastViewState.Loading }
                .subscribe(
                        { _viewState.value = DayForecastViewState.Success(it) },
                        {
                            // handle error
                        }
                )
    }

    private fun fromKelvinToCelsius(temperature: Float): Float {
        return temperature - 273.15f
    }
}