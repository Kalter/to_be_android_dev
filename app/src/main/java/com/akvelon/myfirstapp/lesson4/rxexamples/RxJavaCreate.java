package com.akvelon.myfirstapp.lesson4.rxexamples;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxJavaCreate {

    @NonNull
    public static Flowable<Integer> from() {
        List<Integer> values = new ArrayList<>();
        values.add(5);
        values.add(10);
        values.add(15);
        values.add(20);
        return Flowable.fromIterable(values);
    }

    @NonNull
    public static Flowable<Integer> async() {
        return Flowable.just(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
