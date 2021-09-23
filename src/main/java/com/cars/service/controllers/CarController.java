package com.cars.service.controllers;
import com.cars.service.entites.Car;
import com.cars.service.models.cars.CarBody;
import com.cars.service.services.cars.ICarService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    ICarService carService;
    public CarController() {
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Car>> lisCar(){
        List<Car> list= carService.list();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> getDriver(@PathVariable long id) throws NotFoundException {
       try {
            Car manufacturer = carService.get(id);
            return ResponseEntity.ok(manufacturer);
        }catch (NotFoundException e)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Car> postDriver(@RequestBody CarBody body) throws NotFoundException {
        Car car= carService.add(body);
        return ResponseEntity.ok(car);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Car> putManufacturer(@PathVariable long id,@RequestBody CarBody body) throws NotFoundException {
        try{
            Car car = carService.update(id, body);
            return ResponseEntity.ok(car);
        }catch (NotFoundException e)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}

