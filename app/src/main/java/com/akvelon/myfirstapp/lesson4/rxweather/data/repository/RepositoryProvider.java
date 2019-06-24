package com.akvelon.myfirstapp.lesson4.rxweather.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.akvelon.myfirstapp.lesson4.rxweather.data.repository.weather.RxWeatherRepository;
import com.akvelon.myfirstapp.lesson4.rxweather.data.repository.weather.RxWeatherRepositoryImpl;
import com.akvelon.myfirstapp.lesson4.rxweather.network.ApiFactory;
import com.akvelon.myfirstapp.lesson4.rxweather.network.clients.RxWeatherClient;

public class RepositoryProvider {

    private static volatile RepositoryProvider sInstance;

    @Nullable
    private RxWeatherRepository rxWeatherRepository;

    private RepositoryProvider() {
    }

    public static RepositoryProvider get() {
        if (sInstance == null) {
            synchronized (RepositoryProvider.class) {
                if (sInstance == null) {
                    sInstance = new RepositoryProvider();
                }
            }
        }
        return sInstance;
    }

    @NonNull
    private static <T> T getServiceInstance(Class<T> clazz) {
        return ApiFactory.getRetrofitInstance().create(clazz);
    }

    @NonNull
    public RxWeatherRepository provideNewsFeedRepository() {
        if (rxWeatherRepository == null) {
            rxWeatherRepository = new RxWeatherRepositoryImpl(getServiceInstance(RxWeatherClient.class));
        }
        return rxWeatherRepository;
    }
}