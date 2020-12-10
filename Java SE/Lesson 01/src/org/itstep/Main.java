package org.itstep;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

//Ctrl + Alt + L - выравнивание кода
//Ctrl + P - autocomplete
//Ctrl + / - comment & uncomment
public class Main {
    //https://www.magnumblog.space/java/131-translating-java-code-conventions - Java Code Convention
    public static void main(String[] args) {

        String s;
        int a;

        String str = "Hello world";

        //объявление константы
        final float PI = 3.14f;

        //логический тип
        boolean flag = true;

        System.out.println("Hello world");

        //форматированный вывод
        System.out.format("%s %d\n", str, 100);

        //ввод данных с консоли
        /*Scanner in = new Scanner(System.in);
        System.out.print("a: ");
        int a = in.nextInt();

        System.out.print("b: ");
        int b = in.nextInt();


        System.out.format("a = %d b = %d", a, b);

        //ожидание ввода строки
        String line = in.next();
        System.out.println(line);


        //закрытие потока ввода
        in.close();*/


        /*int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Length = " + nums.length);

        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();*/

        int[][] dArr = new int[10][5];

        for (int i = 0; i < dArr.length; i++) {
            for (int j = 0; j < dArr[i].length; j++) {
                dArr[i][j] = generateRandNum(0, 100);
                System.out.print(dArr[i][j] + "  ");
            }
            System.out.println();
        }


        //объявление зубчатого массива
        int[][] arr = new int[5][];

        //заполнение + инициализация зубчатого массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[generateRandNum(5, 15)];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = generateRandNum(-50, 50);
            }
        }

        printArray(arr);


    }

    static int generateRandNum(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
