package com.akvelon.myfirstapp.lesson7.ui.screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.akvelon.myfirstapp.R;

public class DayForecastMvpActivity extends AppCompatActivity implements DayForecastMvpView {

    private TextView dayInfoView;

    private ProgressBar progressBar;

    private DayForecastMvpPresenter presenter;

    public static void start(@NonNull Context context) {
        context.startActivity(new Intent(context, DayForecastMvpActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_mvp_day_forecast);
        dayInfoView = findViewById(R.id.tvDayForecast);
        progressBar = findViewById(R.id.progressBar);
        findViewById(R.id.btnLoadWithRxJava).setOnClickListener(v ->
                presenter.onRefreshWeatherClick());

        presenter = new DayForecastMvpPresenter(this);
        presenter.onAttachView();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showTemperatureInCelsius(float temperatureInCelsius) {
        dayInfoView.setText(getString(R.string.temp_celsius_pattern, temperatureInCelsius));
    }

    @Override
    protected void onDestroy() {
        presenter.onDetachView();
        super.onDestroy();
    }
}
