package com.example.poc.miscellaneous;

public class SingleTonExample {
    private static volatile SingleTonExample INSTANCE = null;

    private SingleTonExample() {
    }

    public static SingleTonExample getInstance() {
        if (INSTANCE == null) {
            synchronized (SingleTonExample.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingleTonExample();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

    }
}
