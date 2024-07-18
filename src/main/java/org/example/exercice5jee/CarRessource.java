package org.example.exercice5jee;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice5jee.entity.Car;
import org.example.exercice5jee.services.CarService;

import java.util.List;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarRessource {

    private final CarService carService;

    @Inject
    public CarRessource(CarService carService) {
        this.carService = carService;
    }

    @GET
    public List<Car> getAllCars() {
        return carService.getCarList();
    }

    @GET
    @Path("/{id}")
    public Car getCarById(@PathParam("id") long id) {
        return carService.getById(id);
    }

    @POST
    public Car addCar(Car car) {
        carService.createCar(car.getId(), car.getBrand(), car.getYear(), car.getColor());
        return car;
    }

    @DELETE
    @Path("{id}")
    public void deleteCar(@PathParam("id") long id) {
        carService.deleteCar(id);
    }

    @PUT
    @Path("{id}")
    public Car updateCar(@PathParam("id") long id, Car car) {
        car.setId(id);
        return carService.updateCar(car.getId(), car.getBrand(), car.getYear(), car.getColor());
    }
}

//http://localhost:8080/exercie5jee_war_exploded/api/car