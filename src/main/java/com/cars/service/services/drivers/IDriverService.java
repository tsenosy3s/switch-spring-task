package com.cars.service.services.drivers;

import com.cars.service.entites.Driver;
import com.cars.service.entites.Manufacturer;
import com.cars.service.models.drivers.DriverBody;
import com.cars.service.models.drivers.DriverCarBody;
import com.cars.service.models.manufacturers.ManufacturerBody;
import javassist.NotFoundException;

import java.util.List;

public interface IDriverService {
    public List<Driver> list();

    public Driver get(Long id) throws NotFoundException;

    public Driver add(DriverBody body);

    public Driver update(long id, DriverBody body) throws NotFoundException;

    public Driver select(DriverCarBody body) throws NotFoundException;
    public Driver deSelect(DriverCarBody body) throws NotFoundException;

}
