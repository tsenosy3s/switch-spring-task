package com.cars.service.controllers;

import com.cars.service.entites.Driver;
import com.cars.service.models.drivers.DriverBody;
import com.cars.service.models.drivers.DriverCarBody;
import com.cars.service.services.drivers.IDriverService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    IDriverService driverService;
    public DriverController() {
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Driver>> listDriver(){
        List<Driver> list= driverService.list();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable long id) throws NotFoundException {
        Driver manufacturer= driverService.get(id);
        return ResponseEntity.ok(manufacturer);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Driver> postDriver(@RequestBody DriverBody body) throws NotFoundException {
        Driver driver= driverService.add(body);
        return ResponseEntity.ok(driver);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Driver> putManufacturer(@PathVariable long id,@RequestBody DriverBody body) throws NotFoundException {
        Driver driver= driverService.update(id,body);
        return ResponseEntity.ok(driver);
    }
    @PostMapping(path = "/select")
    public ResponseEntity<Driver> selectCar(@RequestBody DriverCarBody body) throws NotFoundException {
        Driver driver= driverService.select(body);
        return ResponseEntity.ok(driver);
    }
    @PostMapping(path = "/deselect")
    public ResponseEntity<Driver> deSelectCar(@RequestBody DriverCarBody body) throws NotFoundException {
        Driver driver= driverService.deSelect(body);
        return ResponseEntity.ok(driver);
    }

}
