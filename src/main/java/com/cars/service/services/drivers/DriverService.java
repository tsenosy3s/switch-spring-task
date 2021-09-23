package com.cars.service.services.drivers;

import com.cars.service.entites.Car;
import com.cars.service.entites.Driver;
import com.cars.service.models.drivers.DriverBody;
import com.cars.service.models.drivers.DriverCarBody;
import com.cars.service.repositories.cars.CarRepository;
import com.cars.service.repositories.drivers.DriverRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService implements IDriverService{


    @Autowired
    DriverRepository driverRep;

    @Autowired
    CarRepository carRep;

    @Override
    public List<Driver> list() {
        return driverRep.findAll();
    }

    @Override
    public Driver get(Long id) throws NotFoundException {
        return driverRep.findById(id).orElseThrow(()->new NotFoundException("Item not found"));
    }

    @Override
    public Driver add(DriverBody body)  {
        Driver driver = new Driver(body.name);
        return  driverRep.save(driver);
    }

    @Override
    public Driver update(long id, DriverBody body) throws NotFoundException {
        Driver driver= driverRep.findById(id).orElseThrow(()->new NotFoundException("Item not found"));
        driver.setName(body.name);
        return driverRep.save(driver);
    }

    @Override
    public Driver select(DriverCarBody body) throws NotFoundException {
       Driver driver = driverRep.findById(body.driverId).get();
       Car car =carRep.findById(body.carId).get();
        driver.getCars().add(car);
        return driverRep.save(driver);
    }

    @Override
    public Driver deSelect(DriverCarBody body) throws NotFoundException {
        Driver driver = driverRep.findById(body.driverId).get();
        Car car =carRep.findById(body.carId).get();
        driver.getCars().remove(car);
        return driverRep.save(driver);
    }


}
