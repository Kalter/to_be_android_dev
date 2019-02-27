package com.akvelon.myfirstapp;

import android.content.Intent;
import android.os.Bundle;

import com.akvelon.myfirstapp.lesson1.CounterActivity;
import com.akvelon.myfirstapp.lesson2.intents.ColorChooserActivity;
import com.akvelon.myfirstapp.lesson2.recyclerview.RecyclerViewActivity;
import com.akvelon.myfirstapp.lesson3.ui.DayForecastActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
}
