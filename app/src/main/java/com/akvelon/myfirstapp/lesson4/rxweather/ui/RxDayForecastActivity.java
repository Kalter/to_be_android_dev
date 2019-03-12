package com.akvelon.myfirstapp.lesson4.rxweather.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akvelon.myfirstapp.R;
import com.akvelon.myfirstapp.lesson4.rxweather.data.repository.RepositoryProvider;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    void loadDayForecastWitRx() {
        compositeDisposable.add(RepositoryProvider.get()
                .provideNewsFeedRepository()
                .getDayForecast("Kazan")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> dayInfoView.setText(response.getDayForecastInfo().toString()),
                        throwable -> {
                            // Handle errors
                        })
        );
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
