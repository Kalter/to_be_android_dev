package com.akvelon.myfirstapp.lesson4.homework;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class Task4Test {

    @Test
    public void testFirstStream() throws Exception {
        Observable<Integer> observable = RxJavaTask4.task4(Observable.just(true),
                Observable.just(1, 2, 8), Observable.just(5));
        testObservable(Observable.just(1, 2, 8), observable);
    }

    @Test
    public void testFirstStreamError() throws Exception {
        Observable<Integer> observable = RxJavaTask4.task4(Observable.just(true),
                Observable.just(98, 7, 99, 61, 134, 14), Observable.just(1, 2, 3, 4, 5));
        observable.test().assertError(Exception.class);
    }

    @Test
    public void testSecondStream() throws Exception {
        Observable<Integer> observable = RxJavaTask4.task4(Observable.just(false),
                Observable.just(1, 2, 8), Observable.just(5));
        testObservable(Observable.just(5), observable);
    }

    @Test
    public void testSecondStreamError() throws Exception {
        Observable<Integer> observable = RxJavaTask4.task4(Observable.just(false),
                Observable.just(98, 7, 99, 61, 134, 14), Observable.just(1, 100, 3, 4, 5));
        observable.test().assertError(Exception.class);
    }

    private void testObservable(@NonNull Observable<Integer> expected, @NonNull Observable<Integer> observable) {
        List<Integer> expectedList = expected.toList().blockingGet();
        List<Integer> resultList = observable.toList().blockingGet();
        assertEquals(expectedList.size(), resultList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), resultList.get(i));
        }
    }
}