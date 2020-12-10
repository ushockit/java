package org.example.models;

import org.example.utils.Random;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class DownloadManager extends Thread {
    static Semaphore sem = new Semaphore(5);
    static Random rnd = new Random();

    private String path;

    public DownloadManager(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        //случайное время

        int time = rnd.generate(5, 15);

        try {
            //запрос разрешения
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //загрузка файла...
        while(time > 0) {
            System.out.println(String.format("Загрузка файла по пути '%s'. Осталось времени: %dс.", path, time));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time--;
        }
        //освобождение семафора
        sem.release();
        System.out.println(String.format("Файл '%s' загружен.", path));
    }
}
