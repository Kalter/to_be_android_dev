package com.akvelon.myfirstapp.lesson4.rxintro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.akvelon.myfirstapp.R;

import java.io.IOException;

import androidx.annotation.Nullable;

class RxIntroActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_rx_intro);
        final TextView username = findViewById(R.id.username_tv);

        UserManager um = new UserManagerStub();
        username.setText(um.getUser().toString());

        um.setName("Jane Doe", new UserManager.Listener() {
            @Override
            public void success() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!isDestroyed()) {
                            username.setText(um.getUser().toString());
                        }
                    }
                });
            }

            @Override
            public void failure(IOException e) {
                // TODO show the error...
            }
        });
    }

    interface UserManager {
        User getUser();

        void setName(String name, Listener callback);

        void setAge(int age, Listener callback);

        interface Listener {
            void success();

            void failure(IOException e);
        }
    }

    static class UserManagerStub implements UserManager {

        @Override
        public User getUser() {
            return null;
        }

        @Override
        public void setName(String name, Listener callback) {

        }

        @Override
        public void setAge(int age, Listener callback) {

        }
    }

}
