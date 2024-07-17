package org.example.exercice5jee;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
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
}


//http://localhost:8080/exercie5jee_war_exploded/api/car