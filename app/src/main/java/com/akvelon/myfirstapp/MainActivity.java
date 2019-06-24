package com.akvelon.myfirstapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.akvelon.myfirstapp.lesson1.CounterActivity;
import com.akvelon.myfirstapp.lesson2.intents.ColorChooserActivity;
import com.akvelon.myfirstapp.lesson2.recyclerview.RecyclerViewActivity;
import com.akvelon.myfirstapp.lesson3.ui.DayForecastActivity;
import com.akvelon.myfirstapp.lesson4.rxweather.ui.RxDayForecastActivity;
import com.akvelon.myfirstapp.lesson5.fragments.dynamic_fragments.DynamicFragmentsHostActivity;
import com.akvelon.myfirstapp.lesson5.fragments.static_fragments.StaticFragmentsHostActivity;
import com.akvelon.myfirstapp.lesson6.sqlite.SqliteActivity;
import com.akvelon.myfirstapp.lesson7.ui.screens.DayForecastMvpActivity;
import com.akvelon.myfirstapp.lesson8.DataBindingUserInfoActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLessonOneCounterActivity)
    void openLessonOneCounterScreen() {
        startActivity(new Intent(this, CounterActivity.class));
    }

    @OnClick(R.id.btnLessonTwoColorChooser)
    void openLessonTwoColorChooserScreen() {
        startActivity(new Intent(this, ColorChooserActivity.class));
    }

    @OnClick(R.id.btnLessonTwoRecyclerView)
    void openLessonTwoRecyclerViewScreen() {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    @OnClick(R.id.btnLessonThreeDayForecast)
    void openLessonThreeDayForecastScreen() {
        DayForecastActivity.start(this);
    }

    @OnClick(R.id.btnLessonForthDayForecast)
    void openLessonForthRxDayForecastScreen() {
        RxDayForecastActivity.start(this);
    }

    @OnClick(R.id.btnLessonFifthStaticFragments)
    void openLessonFifthStaticFragmentsScreen() {
        StaticFragmentsHostActivity.start(this);
    }

    @OnClick(R.id.btnLessonFifthDynamicFragments)
    void openLessonFifthDynamicFragmentsScreen() {
        DynamicFragmentsHostActivity.start(this);
    }

    @OnClick(R.id.btnLessonSixthSqlite)
    void openLessonSixthSqliteScreen() {
        SqliteActivity.start(this);
    }

    @OnClick(R.id.btnLessonSeventhRoom)
    void openLessonSeventhMVPForecastScreen() {
        DayForecastMvpActivity.start(this);
    }

    @OnClick(R.id.btnLessonEightDataBinding)
    void openLessonEightDataBindingScreen() {
        DataBindingUserInfoActivity.start(this);
    }

}
