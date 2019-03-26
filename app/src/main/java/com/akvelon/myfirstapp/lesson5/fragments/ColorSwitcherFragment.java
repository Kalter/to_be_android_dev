package com.akvelon.myfirstapp.lesson5.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akvelon.myfirstapp.R;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ColorSwitcherFragment extends Fragment {

    @ColorInt
    @BindColor(R.color.blue_1E88E5)
    int blueColor;

    @ColorInt
    @BindColor(R.color.red_E53935)
    int redColor;

    @BindView(R.id.root_container) View rootContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fr_colors_switcher, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rootContainer.setBackgroundColor(blueColor);
    }

    @OnClick(R.id.switch_red_btn)
    void switchToRed() {
        rootContainer.setBackgroundColor(redColor);
    }

    @OnClick(R.id.switch_blue_btn)
    void switchToBlue() {
        rootContainer.setBackgroundColor(blueColor);
    }
}
