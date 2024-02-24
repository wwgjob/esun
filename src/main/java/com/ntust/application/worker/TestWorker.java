package com.ntust.application.worker;

import com.ntust.application.worker.actions.TestActionWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestWorker {
    private final TestActionWorker testActionWorker;

    public void test(){
        testActionWorker.test();
    }

    public int getTestValue(){
        return testActionWorker.getTestValue();
    }
}
