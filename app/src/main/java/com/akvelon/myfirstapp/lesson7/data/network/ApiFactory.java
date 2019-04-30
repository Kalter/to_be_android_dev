package com.akvelon.myfirstapp.lesson7.data.network;

import android.support.annotation.NonNull;

import com.akvelon.myfirstapp.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiFactory {

    private static Retrofit sRetrofit;

    private static OkHttpClient sHttpClient;

    private ApiFactory() {
    }

    @NonNull
    public static Retrofit getRetrofitInstance() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_BASE_URL)
                    .client(provideClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    public static OkHttpClient getHttpClient() {
        return sHttpClient;
    }

    @NonNull
    private static OkHttpClient provideClient() {
        if (sHttpClient == null) {
            sHttpClient = OkHttpProvider.provideClient();
        }
        return sHttpClient;
    }
}