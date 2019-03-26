package com.akvelon.myfirstapp.lesson5.fragments.static_fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.akvelon.myfirstapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StaticFragmentsHostActivity extends AppCompatActivity {

    public static void start(@NonNull Context context) {
        context.startActivity(new Intent(context, StaticFragmentsHostActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_static_fragments_host);
    }
}
