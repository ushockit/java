package org.itstep;

public class Person {
    public class Passport {
        private String series;
        private int number;

        public Passport(String series, int number) {
            this.series = series;
            this.number = number;
        }


        public void show() {
            //Person.this - можно обращатсья только в том случае, если вложенный класс не статический
            System.out.println(String.format("%s %s", Person.this.lastName, Person.this.firstName));
            System.out.println(String.format("%s %d", series, number));
        }
    }
    private String firstName;
    private String lastName;
    private int age;
    private Passport passport;

    public Person() {

    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Passport getPassport() {
        return passport;
    }
    public void createPassport(String series, int number) {
        this.passport = new Passport(series, number);
    }
    public void setBodyInfo() {
        class BodyInfo {
            double weight;

            public BodyInfo(double weight) {
                this.weight = weight;
            }
        }
    }
}
