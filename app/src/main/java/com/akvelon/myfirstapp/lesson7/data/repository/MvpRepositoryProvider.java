package com.akvelon.myfirstapp.lesson7.data.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.akvelon.myfirstapp.lesson4.rxweather.network.ApiFactory;
import com.akvelon.myfirstapp.lesson4.rxweather.network.clients.RxWeatherClient;
import com.akvelon.myfirstapp.lesson7.data.repository.weather.MvpWeatherRepository;
import com.akvelon.myfirstapp.lesson7.data.repository.weather.MvpWeatherRepositoryImpl;

public class MvpRepositoryProvider {

    private static volatile MvpRepositoryProvider sInstance;

    @Nullable
    private MvpWeatherRepository mvpWeatherRepository;

    private MvpRepositoryProvider() {
    }

    public static MvpRepositoryProvider get() {
        if (sInstance == null) {
            synchronized (MvpRepositoryProvider.class) {
                if (sInstance == null) {
                    sInstance = new MvpRepositoryProvider();
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
    public MvpWeatherRepository provideNewsFeedRepository() {
        if (mvpWeatherRepository == null) {
            mvpWeatherRepository = new MvpWeatherRepositoryImpl(getServiceInstance(RxWeatherClient.class));
        }
        return mvpWeatherRepository;
    }
}