package com.akvelon.myfirstapp.lesson4.homework;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class Task2Test {

    @Test
    public void testEmptyStream() throws Exception {
        testObservable(Observable.empty(), RxJavaTask2.task2(Observable.just("END")));
    }

    @Test
    public void testNoEndWord() throws Exception {
        testObservable(Observable.just("123", "abc"), RxJavaTask2.task2(Observable.just("123", "abc")));
    }

    @Test
    public void testRepeatedElementsRemoved() throws Exception {
        testObservable(Observable.just("xx", "xxy"),
                RxJavaTask2.task2(Observable.just("xx", "xxy", "xx", "xxy", "xxy", "END")));
    }

    private void testObservable(@NonNull Observable<String> expected, @NonNull Observable<String> observable) {
        List<String> expectedList = expected.toList().blockingGet();
        List<String> resultList = observable.toList().blockingGet();
        assertEquals(expectedList.size(), resultList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), resultList.get(i));
        }
    }
}