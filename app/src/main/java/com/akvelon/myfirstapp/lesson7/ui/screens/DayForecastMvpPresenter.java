package com.akvelon.myfirstapp.lesson7.ui.screens;

import androidx.annotation.NonNull;

import com.akvelon.myfirstapp.lesson7.base.BasePresenter;
import com.akvelon.myfirstapp.lesson7.data.repository.MvpRepositoryProvider;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class DayForecastMvpPresenter implements BasePresenter {

    private static final String DEFAULT_CITY = "Kazan";

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @NonNull
    private final DayForecastMvpView view;

    public DayForecastMvpPresenter(@NonNull DayForecastMvpView view) {
        this.view = view;
    }

    @Override
    public void onAttachView() {
        fetchCityWeather(DEFAULT_CITY);
    }

    @Override
    public void onDetachView() {
        compositeDisposable.dispose();
    }

    public void onRefreshWeatherClick() {
        fetchCityWeather(DEFAULT_CITY);
    }

    private void fetchCityWeather(@NonNull String city) {
        compositeDisposable.add(MvpRepositoryProvider.get()
                .provideNewsFeedRepository()
                .getDayForecast(city)
                .flatMap(dayForecastResponse ->
                        Single.just(dayForecastResponse.getDayForecastInfo().getDayTempInfo()))
                .map(this::fromKelvinToCelsius)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(subscription -> view.showProgressBar())
                .doFinally(view::hideProgressBar)
                .subscribe(view::showTemperatureInCelsius,
                        throwable -> {
                        })
        );
    }

    private float fromKelvinToCelsius(final float temperature) {
        return temperature - 273.15f;
    }
}
