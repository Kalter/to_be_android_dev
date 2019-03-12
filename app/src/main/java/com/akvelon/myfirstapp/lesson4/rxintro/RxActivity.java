package com.akvelon.myfirstapp.lesson4.rxintro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.akvelon.myfirstapp.R;

import androidx.annotation.Nullable;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

class RxActivity extends Activity {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_rx_intro);
        final TextView usernameTextView = findViewById(R.id.username_tv);

        UserManager um = new UserManagerStub();
        compositeDisposable.add(um.getUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> usernameTextView.setText(user.toString()),
                        throwable -> {
                            // TODO show the error...
                        })
        );

        compositeDisposable.add(um.setName("Jane Doe")
                .andThen(um.getUser())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> usernameTextView.setText(user.toString()),
                        throwable -> {
                            // TODO show the error...
                        })
        );
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }

    interface UserManager {
        Single<User> getUser();

        Completable setName(String name);

        Completable setAge(int age);

    }

    static class UserManagerStub implements UserManager {

        @Override
        public Single<User> getUser() {
            return null;
        }

        @Override
        public Completable setName(String name) {
            return null;
        }

        @Override
        public Completable setAge(int age) {
            return null;
        }
    }

}
