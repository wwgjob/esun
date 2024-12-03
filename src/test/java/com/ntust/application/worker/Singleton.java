package com.ntust.application.worker;

import org.junit.jupiter.api.Test;

public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    @Test
    public void main() {
        Singleton logger1 = Singleton.getInstance(); // 第一次呼叫，創建實例
        Singleton logger2 = Singleton.getInstance(); // 第二次呼叫，返回相同實例

        System.out.println(logger1 == logger2); // true，確認兩者是同一個實例
    }
}

