package com.cars.service.services.cars;

import com.cars.service.entites.Car;
import com.cars.service.entites.Manufacturer;
import com.cars.service.models.cars.CarBody;
import com.cars.service.repositories.cars.CarRepository;
import com.cars.service.repositories.manufacturers.ManufacturerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService{

    @Autowired
    CarRepository carRep;
    @Autowired
    ManufacturerRepository manRep;

    @Override
    public List<Car> list() {
        return carRep.findAll();
    }

    @Override
    public Car get(Long id) throws NotFoundException {
        return carRep.findById(id).orElseThrow(()-> new NotFoundException("Item not found"));
    }

    @Override
    public Car add(CarBody body) throws NotFoundException {
        Manufacturer man= manRep.findById(body.manufacturerId).orElseThrow(()-> new NotFoundException("Item not found"));;
        Car car=new Car(body.licensePlate,body.seatCount,body.convertible,body.rating,body.engineType,man);
        return carRep.save(car);
    }

    @Override
    public Car update(long id, CarBody body) throws NotFoundException {

        Manufacturer man= manRep.findById(body.manufacturerId).orElseThrow(()-> new NotFoundException("Item not found"));

        Car car=carRep.findById(id).orElseThrow(()-> new NotFoundException("Item not found"));
        car.setLicensePlate(body.licensePlate);
        car.setEngineType(body.engineType);
        car.setManufacturer(man);
        car.setRating(body.rating);
        car.setConvertible(body.convertible);
        car.setSeatCount(body.seatCount);
        return carRep.save(car);

    }
}
