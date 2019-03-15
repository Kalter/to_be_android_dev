package com.akvelon.myfirstapp.lesson4.homework;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

import java.math.BigInteger;

public class RxJavaTask5 {

    /**
     * TODO : you have two streams of integers of equal length
     * <p>
     * Return one stream of the same length with GCDs
     * of the original streams values
     * <p>
     * Example:
     * Stream 1 (100, 17, 63)
     * Stream 2 (15, 89, 27)
     * Result stream (5, 1, 9)
     * <p>
     * You can use {@link java.math.BigInteger#gcd(BigInteger)}
     */
    @NonNull
    public static Observable<Integer> gcdsObservable(@NonNull Observable<Integer> first,
                                                     @NonNull Observable<Integer> second) {
        return Observable.just(0);
    }

}