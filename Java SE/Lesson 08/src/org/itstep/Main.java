package org.itstep;

import java.time.LocalTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //AtomicInteger number = new AtomicInteger(1);

        //пул с фиксированным кол-вом потоков
        //ExecutorService service = Executors.newFixedThreadPool(5);
        /*for(int i = 0; i < 3; i++) {
            service.execute(() -> {
                Thread.currentThread().setName(String.format("#%d", number.getAndIncrement()));

                int counter = 10;
                while(counter > 0) {
                    System.out.println(String.format("Hello from %s", Thread.currentThread().getName()));
                    counter--;

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }*/

        /*String path = "some path...";

        Future<byte[]> future = service.submit(() -> {
            System.out.println("Download from - " + path);
            System.out.println("Wait!");

            for (int i = 5; i > 0; i--) {
                System.out.println(String.format("Downloading %d", i) + "%");
                Thread.sleep(1000);
            }
            String data = "downloaded data";
            return data.getBytes();
        });

        Thread.sleep(6000);

        if (future.isDone()) {
            byte[] data = future.get();
            System.out.println(new String(data));
        }*/

        //service.shutdown();


        //кешируемый пул, который переиспользует ранее созданные потоки, если они уже свободны
        //ExecutorService service = Executors.newCachedThreadPool();

        //отложеный запуск потоков

        ScheduledExecutorService service =  Executors.newSingleThreadScheduledExecutor();

        //запуск потока с задержкой в 2 секунды
        /*service.schedule(() -> {
            System.out.println("Прошло 2 секунды и поток начал свою работу");
        }, 2, TimeUnit.SECONDS);*/

        /*service.scheduleAtFixedRate(() -> {
            LocalTime time = LocalTime.now();
            System.out.println(time.toString());
        }, 0, 1, TimeUnit.SECONDS);
        Thread.sleep(5000);*/


        service.shutdown();
    }
}
