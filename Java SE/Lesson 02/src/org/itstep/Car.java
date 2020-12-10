package org.itstep;

public class Car extends Vehicle implements Movement{
    static int objectsCounter;

    //статический инициализатор
    static {
        objectsCounter = 0;
    }

    public Car(String name, double speed) {
        //вызов конструктора базового класса
        super(name, speed);
    }

    @Override
    public String toString() {
        return String.format("speed: %f name: %s", speed, name);
    }

    @Override
    public void up() {

    }

    @Override
    public void down() {

    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }
}
