package com.akvelon.myfirstapp.lesson5.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akvelon.myfirstapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CounterFragment extends Fragment {

    @BindView(R.id.counter_tv) TextView counterText;

    private int counter = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fr_counter, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        counterText.setText(String.valueOf(counter));
    }

    @OnClick(R.id.btn_plus_one)
    void plusOne() {
        counter++;
        counterText.setText(String.valueOf(counter));
    }

    @OnClick(R.id.btn_minus_one)
    void minusOne() {
        counter--;
        counterText.setText(String.valueOf(counter));
    }
}
