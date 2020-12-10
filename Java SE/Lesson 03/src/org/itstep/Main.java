package org.itstep;


import org.itstep.exceptions.DivideByZeroException;
import org.itstep.exceptions.NegativeValueException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        /*int a = 10;
        int b = 0;
        try {
            int c = a / b;
        }
        catch(ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }*/
        /*try {
            division(5, 12);
        } catch (DivideByZeroException | NegativeValueException e) {
            e.printStackTrace();
        }*/

        /*try {
            Demo1();
        }
        catch(NullPointerException ex) {
            System.out.println("Error in Main");
        }*/


        // -= работа с строками =-
        //StringBuffer - используется в многопоточных приложениях
        //StringBuilder - используется в однопоточных приложениях
        /*StringBuilder builder = new StringBuilder();

        builder.append("Hello");
        builder.append(" world");
        builder.append("!!!");

        String strResult = builder.toString();
        System.out.println(strResult);*/

        /*String str = "Hello world!!!";

        String[] res = str.split("\\s");*/

        Pattern pattern = Pattern.compile("\\b[Ii]\\w+");
        Matcher m = pattern.matcher("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vitae justo eget magna fermentum. Vulputate odio ut enim blandit volutpat maecenas. Enim nec dui nunc mattis enim ut tellus. Tempus imperdiet nulla malesuada pellentesque elit eget gravida cum.");

        if (Pattern.matches("\\w+", "Hello")) {
            System.out.println("Da");
        }
        while (m.find()) {
            String g = m.group();
            System.out.println(g);
        }

//        if (m.matches()) {
//            System.out.println("Yes");
//        }
//        else {
//            System.out.println("No");
//        }
    }

    static double division(int a, int b) throws DivideByZeroException, NegativeValueException {
        if (b == 0) {
            throw new DivideByZeroException("/ by zero");
        }
        if (a < 0 || b < 0) {
            throw new NegativeValueException("Value can`t be less 0");
        }
        return a / b;
    }

    static void Demo1() throws NullPointerException {
        Demo2(null);
    }

    static void Demo2(String arg) throws NullPointerException {
        if (arg == null) {
            throw new NullPointerException();
        }
    }
}
