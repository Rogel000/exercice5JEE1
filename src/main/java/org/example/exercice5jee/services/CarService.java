package org.example.exercice5jee.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exercice5jee.entity.Car;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarService {
    private List<Car> carList = new ArrayList<>();

    public void createCar(long id, String brand, int year, String color) {
        Car car = new Car(id, brand, year, color);
        carList.add(car);
    }

    public List<Car> getCarList() {

        return List.of(
                new Car(2, "Tesla", 2022, "Blanc"),
                new Car(2, "Ford", 2019, "Rouge"),
                new Car(3, "BMW", 2020, "Noir")
        );
    }

    public Car getById(long id) {
        return getCarList().stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }

    public void deleteCar(long id) {
        getCarList().removeIf(car -> car.getId() == id);
    }

    public Car updateCar(long id, String brand, int year, String color) {
        Car carToUpdate = getById(id);
        if (carToUpdate != null) {
            carToUpdate.setBrand(brand);
            carToUpdate.setYear(year);
            carToUpdate.setColor(color);
        }
        return carToUpdate;
    }

}



