package org.itstep;

import org.itstep.database.*;       //импорт всех классе из пакета org.itstep.database
//import org.itstep.database.DbConnection;      //импорт конкретного класса из пакета org.itstep.database

public class Main {
    public static void main(String[] args) {
        //Person.Passport passport = new Person.Passport("AE", 56701);
        /*Person person = new Person("Vasya", "Pupkin", 10);

        Person.Passport passport = person.getPassport();

        Vehicle car = new Car("Some car", 25000);

        System.out.println(car);*/

        Person person = new Person("Vasya", "Pupkin", 10);
        person.createPassport("AE", 56601);
        person.getPassport().show();


        //System.out.println(Color.BLACK);
        /*System.out.println(Color.BLACK.name());
        System.out.println(Color.GREEN.getColor());*/

    }
}
