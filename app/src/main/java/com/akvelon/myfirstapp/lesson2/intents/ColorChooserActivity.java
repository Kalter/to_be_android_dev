package com.akvelon.myfirstapp.lesson2.intents;

import android.os.Bundle;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.akvelon.myfirstapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class ColorChooserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_color_chooser);

        findViewById(R.id.btnRed).setOnClickListener(v ->
                openDetailsActivity("Red", android.R.color.holo_red_dark));
        findViewById(R.id.btnOrange).setOnClickListener(v ->
                openDetailsActivity("Orange", android.R.color.holo_orange_dark));
        findViewById(R.id.btnGreen).setOnClickListener(v ->
                openDetailsActivity("Green", android.R.color.holo_green_light));
    }

    private void openDetailsActivity(@NonNull String colorName, @ColorRes int colorRes) {
        ColorDetailsInfoActivity.start(this, colorName, colorRes);
    }
}
