package com.cars.service.services.cars;

import com.cars.service.entites.Car;
import com.cars.service.entites.Driver;
import com.cars.service.models.cars.CarBody;
import com.cars.service.models.drivers.DriverBody;
import javassist.NotFoundException;

import java.util.List;

public interface ICarService {

    public List<Car> list();

    public Car get(Long id) throws NotFoundException;

    public Car add(CarBody body) throws NotFoundException;

    public Car update(long id, CarBody body) throws NotFoundException;

}
