package com.ntust.application.worker.actions;

import org.springframework.stereotype.Component;

@Component
public class TestActionWorker {

    public void test() {
        System.out.println("test");
    }

    public int getTestValue() {
        return 1;
    }
}
