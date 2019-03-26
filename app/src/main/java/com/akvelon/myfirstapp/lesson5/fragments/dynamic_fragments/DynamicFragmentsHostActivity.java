package com.akvelon.myfirstapp.lesson5.fragments.dynamic_fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.akvelon.myfirstapp.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DynamicFragmentsHostActivity extends AppCompatActivity {

    @BindView(R.id.add_to_back_stack_switch) SwitchMaterial addToBackStackSwitch;

    private Fragment pageOneFragment;
    private Fragment pageTwoFragment;

    public static void start(Context context) {
        context.startActivity(new Intent(context, DynamicFragmentsHostActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_dynamic_fragments_host);
        ButterKnife.bind(this);

        pageOneFragment = new PageOneFragment();
        pageTwoFragment = new PageTwoFragment();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.add_fragment_btn)
    void onAddFragmentClick() {
        addFragment(pageOneFragment, "page_one");
    }

    @OnClick(R.id.replace_fragment_btn)
    void onReplaceFragmentClick() {
        replaceFragment(pageTwoFragment, "page_two");
    }

    @OnClick(R.id.remove_fragment_btn)
    void onRemoveFragmentClick() {
        removeFragment(pageTwoFragment);
    }

    private void addFragment(@NonNull Fragment fragment, @NonNull String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .addToBackStack(addToBackStackSwitch.isChecked() ? tag : null)
                .commit();
    }

    private void replaceFragment(@NonNull Fragment fragment, @NonNull String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(addToBackStackSwitch.isChecked() ? tag : null)
                .commit();
    }

    private void removeFragment(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .remove(fragment)
                .commit();
    }
}
