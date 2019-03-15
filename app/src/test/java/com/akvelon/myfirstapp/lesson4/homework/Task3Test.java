package com.akvelon.myfirstapp.lesson4.homework;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class Task3Test {

    @Test
    public void testEmptyObservable() throws Exception {
        testResult(0, Observable.empty());
    }

    @Test
    public void testSingleValue() throws Exception {
        testResult(1213, Observable.just(1213));
    }

    @Test
    public void testSmallSum() throws Exception {
        testResult(21, Observable.just(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void testSmallNegativeSum() throws Exception {
        testResult(-8, Observable.just(10, 9, -27));
    }

    @Test
    public void testLargeSum() throws Exception {
        testResult(6005420, Observable.just(40112, 549242, 104, -10013, -9, 5425984));
    }

    @Test
    public void testIntegerOverflow() throws Exception {
        testResult(-Integer.MAX_VALUE, Observable.just(Integer.MAX_VALUE, 1, 1));
    }

    private void testResult(int expected, @NonNull Observable<Integer> values) {
        int result = RxJavaTask3.sum(values)
                .blockingGet();
        assertEquals(expected, result);
    }
}