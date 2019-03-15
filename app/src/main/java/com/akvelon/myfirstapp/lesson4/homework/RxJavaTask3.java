package com.akvelon.myfirstapp.lesson4.homework;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class RxJavaTask3 {

    /**
     * TODO :
     * Sum all elements from observable and return observable with this single sum
     * <p>
     * Example:
     * Input stream (1, 2, 3, 4, 5)
     * Result stream (15)
     * <p>
     * Find suitable operator for this task using Google
     * Do not use RxMath library
     */
    @NonNull
    public static Single<Integer> sum(@NonNull Observable<Integer> observable) {
        return Single.just(0);
    }

}