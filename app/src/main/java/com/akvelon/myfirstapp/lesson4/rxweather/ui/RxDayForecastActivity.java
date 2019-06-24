package com.akvelon.myfirstapp.lesson4.rxweather.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.akvelon.myfirstapp.R;
import com.akvelon.myfirstapp.lesson4.rxweather.data.repository.RepositoryProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RxDayForecastActivity extends AppCompatActivity {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @BindView(R.id.tvDayForecast)
    TextView dayInfoView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    public static void start(@NonNull Context context) {
        context.startActivity(new Intent(context, RxDayForecastActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_rx_day_forecast);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLoadWithRxJava)
    void loadWeatherWithRetrofitCallback() {
        compositeDisposable.add(RepositoryProvider.get()
                .provideNewsFeedRepository()
                .getDayForecast("Kazan")
                .flatMap(dayForecastResponse ->
                        Single.just(dayForecastResponse.getDayForecastInfo().getDayTempInfo()))
                .map(this::fromKelvinToCelsius)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(subscription -> showProgressBar())
                .doFinally(this::hideProgressBar)
                .subscribe(temp -> dayInfoView.setText(temp.toString()),
                        throwable -> {})
        );
    }

    private float fromKelvinToCelsius(final float temperature) {
        return temperature - 273.15f;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

}
