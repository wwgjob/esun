package com.ntust.application.worker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Counter {
    private int count = 0;

    // Synchronized 方法
    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Test
    public void test() throws InterruptedException {
        Counter counter = new Counter();

        // 創建執行緒 1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // 創建執行緒 2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // 啟動執行緒
        t1.start();
        t2.start();

        // 等待執行緒完成
        t1.join();
        t2.join();

        // 測試結果是否符合預期
        assertEquals(2000, counter.getCount(), "計數結果應該是 2000");
    }
}
