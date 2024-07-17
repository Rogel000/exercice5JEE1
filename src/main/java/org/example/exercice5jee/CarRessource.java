package org.example.exercice5jee;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice5jee.entity.Car;
import org.example.exercice5jee.services.CarService;

import java.util.List;

@Path("/car")
public class CarRessource {

    private final CarService carService;

    @Inject
    public CarRessource(CarService carService) {
        this.carService = carService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars() {
        return carService.getCarList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCarById(@PathParam("id") long id) {
        return carService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Car addCar(Car car) {
        return carService.createCar(5L, "Renault",2018,"bleu");
    }

    @DELETE
    @Path("{id}")
    public void deleteCar(@PathParam("id") long id) {
        carService.deleteCar(id);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Car updateCar(@PathParam("id") long id, Car car) {
        car.setId(id);
        return carService.updateCar(car.getId(), car.getBrand(), car.getYear(), car.getColor());
    }
}

//http://localhost:8080/exercie5jee_war_exploded/api/car