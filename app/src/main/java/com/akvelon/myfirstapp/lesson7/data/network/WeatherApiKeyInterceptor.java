package com.akvelon.myfirstapp.lesson7.data.network;

import android.support.annotation.NonNull;

import com.akvelon.myfirstapp.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherApiKeyInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        final Request original = chain.request();
        final HttpUrl originalHttpUrl = original.url();
        final HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("appid", BuildConfig.WEATHER_API_KEY)
                .build();

        return chain.proceed(original.newBuilder().url(url).build());
    }
}