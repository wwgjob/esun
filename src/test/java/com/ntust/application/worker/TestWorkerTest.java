package com.ntust.application.worker;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestWorkerTest {
    @Autowired
    private TestWorker testWorker;

    @Test
    public void testTestWorker() {
        int a = testWorker.getTestValue();
        Assertions.assertEquals(a, 1);

    }
}