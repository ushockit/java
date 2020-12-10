package org.example.models;

public class Demo extends Thread {
    static Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj) {

        }
    }
}
