package com.akvelon.myfirstapp.lesson3.ui;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akvelon.myfirstapp.R;
import com.akvelon.myfirstapp.lesson3.data.models.DayForecastResponse;
import com.akvelon.myfirstapp.lesson3.data.repository.RepositoryProvider;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DayForecastActivity extends AppCompatActivity {

    @BindView(R.id.tvDayForecast)
    TextView dayInfoView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    public static void start(@NonNull Context context) {
        context.startActivity(new Intent(context, DayForecastActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_day_forecast);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLoadWithAsyncTask)
    void loadDayForecastWithAsyncTask() {
        GetTemperatureRequest getTemperatureRequest = new GetTemperatureRequest();
        getTemperatureRequest.execute("Kazan");
    }

    @OnClick(R.id.btnLoadWithRetrofitCallback)
    void loadWeatherWithRetrofitCallback() {
        RepositoryProvider.get()
                .provideNewsFeedRepository()
                .getDayForecast("Kazan")
                .enqueue(new Callback<DayForecastResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<DayForecastResponse> call,
                                           @NonNull Response<DayForecastResponse> response) {
                        if (response.isSuccessful()) {
                            dayInfoView.setText(response.body().getDayForecastInfo().toString());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<DayForecastResponse> call,
                                          @NonNull Throwable t) {
                        // Handle errors
                    }
                });
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    private class GetTemperatureRequest extends AsyncTask<String, Void, DayForecastResponse> {

        @Override
        protected void onPreExecute() {
            showProgressBar();
        }

        @Override
        protected DayForecastResponse doInBackground(String... city) {
            try {
                return RepositoryProvider.get()
                        .provideNewsFeedRepository()
                        .getDayForecast(city[0])
                        .execute()
                        .body();
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(DayForecastResponse fullWeatherInfo) {
            dayInfoView.setText(fullWeatherInfo.getDayForecastInfo().toString());
            hideProgressBar();
        }
    }
}
