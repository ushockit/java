package org.itstep;

import com.google.gson.Gson;
import org.itstep.models.Person;

import java.io.*;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        /*
         * InputStream
         * OutputStream
         * Reader
         * Writer
         * */

        //try-with-resource - позволяет автоматически закрывать поток (аналог using в C#)

        //FileInputStream/FileOutputStream
        /*try(FileOutputStream fos = new FileOutputStream("demo.txt")) {
            String str = "Good afternoon!!!";
            byte[] strBytes = str.getBytes();
            fos.write(strBytes);
            System.out.println("Success write!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream("demo.txt")) {
            byte[] bytes = fis.readAllBytes();
            String str = new String(bytes);
            System.out.println("Success read!");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        //ByteArrayOutputStream/ByteArrayInputStream
        /*try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileOutputStream fos = new FileOutputStream("demo2.txt")) {
            baos.write("Hello world".getBytes());

            //вывод данных в заданный поток
            baos.writeTo(fos);
            System.out.println("Success write!");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try(ByteArrayInputStream bais = new ByteArrayInputStream("Hello world".getBytes())) {
            int b;
            while((b = bais.read()) != -1) {
                System.out.println((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //DataOutputStream/DataInputStream
        /*double x = 5.76;
        double y = 10.31;
        try (FileOutputStream fos = new FileOutputStream("demo3.txt");
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeDouble(x);
            dos.writeDouble(y);
            System.out.println("Success write!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*double x = 0.0;
        double y = 0.0;

        try (FileInputStream fis = new FileInputStream("demo3.txt");
             DataInputStream dis = new DataInputStream(fis)) {
            x = dis.readDouble();
            y = dis.readDouble();
            System.out.println("Success read!!!");
            System.out.println(String.format("x = %f y = %f", x, y));
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        //PrintStream/PrintWriter
        /*try (FileOutputStream fos = new FileOutputStream("demo4.txt");
             PrintStream ps = new PrintStream(fos)) {
            ps.print("Hello world");
            ps.print("Hello friend!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*try(PrintWriter pw = new PrintWriter("demo5.txt")) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/


        //BufferedInputStream/BufferedOutputStream
        /*try (FileOutputStream fos = new FileOutputStream("demo6.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            bos.write("Hello world".getBytes());
            System.out.println("Success write!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*try (FileInputStream fis = new FileInputStream("demo6.txt");
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            String str = new String(bis.readAllBytes());
            System.out.println("Success read!!!");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //BufferedReader/BufferedWriter
        /*try (FileWriter fw = new FileWriter("demo7.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Hello world");
            System.out.println("Success write");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader("demo7.txt");
             BufferedReader br = new BufferedReader(fr)) {
            System.out.println(br.readLine());
            System.out.println("Success read!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //Сериализация объектов
        /*Person person = new Person(1, "First name 1", "Last name 1");

        try (FileOutputStream fos = new FileOutputStream("person.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(person);
            System.out.println("Success write object!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*Person person;

        try (FileInputStream fis = new FileInputStream("person.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        /*File[] roots = File.listRoots();
        int a = 0;

        File[] innerFiles = roots[0].listFiles();

        for (File innerFile : innerFiles) {
            System.out.println(innerFile.getAbsolutePath());
        }*/

        Gson gson = new Gson();

        Person[] people = new Person[]{
                new Person(1, "First name 1", "Last name 1"),
                new Person(2, "First name 2", "Last name 2"),
                new Person(3, "First name 3", "Last name 3")
        };

        String json = gson.toJson(people);
        System.out.println(json);

        Person[] result =  gson.fromJson(json, Person[].class);
        int a = 0;

    }
}
