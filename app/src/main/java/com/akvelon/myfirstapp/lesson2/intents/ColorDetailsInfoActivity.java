package com.akvelon.myfirstapp.lesson2.intents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.akvelon.myfirstapp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ColorDetailsInfoActivity extends AppCompatActivity {

    private static final String EXTRA_COLOR_NAME = "extra_color_name";
    private static final String EXTRA_COLOR_RES = "extra_color_res";
    private static final String EXTRA_COLOR_INFO = "extra_color_info";

    public static void start(@NonNull Context context, @NonNull String colorName, @ColorRes int colorRes) {
        Intent starter = new Intent(context, ColorDetailsInfoActivity.class);
        starter.putExtra(EXTRA_COLOR_NAME, colorName);
        starter.putExtra(EXTRA_COLOR_RES, colorRes);
        context.startActivity(starter);
    }

    public static void start(@NonNull Context context, @NonNull ColorInfo colorInfo) {
        Intent starter = new Intent(context, ColorDetailsInfoActivity.class);
        starter.putExtra(EXTRA_COLOR_INFO, colorInfo);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_color_details_info);

        @ColorRes int colorRes;
        String colorName;

        if (getIntent().getIntExtra(EXTRA_COLOR_RES, -1) != -1) {
            colorRes = getIntent().getIntExtra(EXTRA_COLOR_RES, 0);
            colorName = getIntent().getStringExtra(EXTRA_COLOR_NAME);
        } else {
            ColorInfo colorInfo = getIntent().getParcelableExtra(EXTRA_COLOR_INFO);
            colorName = colorInfo.colorName;
            colorRes = colorInfo.colorRes;
        }

        ((TextView) findViewById(R.id.tvColorName)).setText(colorName);
        findViewById(R.id.vColor).setBackgroundColor(ContextCompat.getColor(this, colorRes));
    }
}
