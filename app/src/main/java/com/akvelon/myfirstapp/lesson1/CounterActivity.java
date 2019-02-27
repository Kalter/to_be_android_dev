package com.akvelon.myfirstapp.lesson1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akvelon.myfirstapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class CounterActivity extends AppCompatActivity {

    int k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_counter);

        final TextView textView = findViewById(R.id.text_view);
        Button plusOneButton = findViewById(R.id.btn_plus_one);
        Button minusOneButton = findViewById(R.id.btn_minus_one);

        textView.setText(String.valueOf(k));
        plusOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k++;
                textView.setText(String.valueOf(k));
            }
        });

        minusOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k--;
                textView.setText(String.valueOf(k));
            }
        });
    }
}
