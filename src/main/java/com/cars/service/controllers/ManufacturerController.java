package com.cars.service.controllers;

import com.cars.service.entites.Manufacturer;
import com.cars.service.models.manufacturers.ManufacturerBody;
import com.cars.service.services.manufacturers.IManufacturerService;
import com.cars.service.services.manufacturers.ManufacturerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {

    @Autowired
    IManufacturerService manService;
    public ManufacturerController() {
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Manufacturer>> getManufacturer(){
    List<Manufacturer> list= manService.list();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Manufacturer> getManufacturer(@PathVariable long id) throws NotFoundException {
        try{
            Manufacturer manufacturer = manService.get(id);
            return ResponseEntity.ok(manufacturer);
        }catch (NotFoundException e)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Manufacturer> postManufacturer(@RequestBody ManufacturerBody body) throws NotFoundException {

            Manufacturer manufacturer = manService.add(body);
            return ResponseEntity.ok(manufacturer);

    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Manufacturer> putManufacturer(@PathVariable long id,@RequestBody ManufacturerBody body) throws NotFoundException {
        try{
            Manufacturer manufacturer = manService.update(id, body);
            return ResponseEntity.ok(manufacturer);
        }catch (NotFoundException e)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}
