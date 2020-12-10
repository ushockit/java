package org.itstep;


import org.itstep.models.Car;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        /*IntStream stream = IntStream.of(10, -20, 300, 11, -203, 0, 12, 76, 44);

        OptionalDouble optAvg = stream.average();
        double avg = optAvg.getAsDouble();
        System.out.println(avg);

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            nums.add(generateValue(10, 1000));
        }

        nums = nums.stream().filter(n -> n % 2 == 0)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        nums.forEach(System.out::println);*/


        List<Car> cars = new ArrayList<>();

        cars.add(new Car(1, "BMW", "X5", 45000));
        cars.add(new Car(2, "Nissan", "GTR", 70000));
        cars.add(new Car(3, "Audi", "RS6", 120000));
        cars.add(new Car(4, "Chevrolet", "Lacetti", 6000));
        cars.add(new Car(5, "Mitsubishi", "Lancer", 9000));
        cars.add(new Car(6, "Mercedes-Benz", "CLS 500", 29000));
        cars.add(new Car(7, "Audi", "A4", 25000));
        cars.add(new Car(8, "Mercedes-Benz", "C63", 60000));
        cars.add(new Car(9, "Audi", "RS7", 160000));
        cars.add(new Car(10, "Nissan", "Skyline", 26000));


        List<Car> newList = cars.stream()
                .filter(car -> car.getPrice() > 20000)
                .collect(Collectors.toList());


        //Map<String, List<Car>> mapCars = cars.stream().collect(Collectors.groupingBy(Car::getMark));

        Map<String, List<Car>> mapCars = cars.parallelStream().filter(car -> car.getPrice() > 20000)
                .collect(Collectors.groupingBy(Car::getMark));

        Car findCar = cars.parallelStream().filter(car -> car.getPrice() < 5000).findFirst().orElse(new Car());

        int a = 0;
    }

    static int generateValue(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min) + min);
    }
}
