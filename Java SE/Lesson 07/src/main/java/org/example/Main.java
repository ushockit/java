package org.example;


import org.example.models.DownloadManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Main thread start");
        /*URL website = new URL("https://dou.ua/");

        try (ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream("dou.html")) {
            long val = fos.getChannel().transferFrom(rbc, 0,Long.MAX_VALUE);
            System.out.println(val);
        }*/

        DownloadManager[] tasks = new DownloadManager[] {
                new DownloadManager("https://files.ru/file1"),
                new DownloadManager("https://files.ru/file2"),
                new DownloadManager("https://files.ru/file3"),
                new DownloadManager("https://files.ru/file4"),
                new DownloadManager("https://files.ru/file5"),
                new DownloadManager("https://files.ru/file6"),
                new DownloadManager("https://files.ru/file7"),
                new DownloadManager("https://files.ru/file8"),
        };

        for (DownloadManager task : tasks) {
            task.start();
        }


        for (DownloadManager task : tasks) {
            task.join();
        }




        System.out.println("Main thread end");
    }
}
