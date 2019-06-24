package com.akvelon.myfirstapp.lesson8;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;

import com.akvelon.myfirstapp.R;
import com.akvelon.myfirstapp.databinding.AcUserInfoBinding;
import com.akvelon.myfirstapp.lesson8.models.DataBindingObservableUserInfo;

public class DataBindingUserInfoActivity extends AppCompatActivity {

    public final ObservableInt counter = new ObservableInt();

    public DataBindingObservableUserInfo observableUserInfo;

    public static void start(@NonNull Context context) {
        final Intent starter = new Intent(context, DataBindingUserInfoActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AcUserInfoBinding binding = DataBindingUtil.setContentView(this, R.layout.ac_user_info);
//        DataBindingUserInfo user = new DataBindingUserInfo("Test", "User");
        observableUserInfo = new DataBindingObservableUserInfo("Test", "User");
        binding.setUser(observableUserInfo);
        binding.setActivity(this);
    }

    public void methodWithAction() {
        observableUserInfo.setLastName(observableUserInfo.getLastName() + "1");
    }

    public void increaseCounter() {
        int v = counter.get();
        counter.set(v + 1);
    }
}
